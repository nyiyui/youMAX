package BlockSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Block_Sort {

    public static void main(String[] args) {
        int a[] = {5, 4, 1, 7, 10, 20, 4, 100, 54, 12, 3, 18, 45, 23, 1, 4, 13, 8, 7, 19, 99, 2, 67, 34, 69, 11, 5, 73,
                23, 10, 35, 17};
        blockSort(a);
        System.out.print("final: ");
        System.out.println(Arrays.toString(a));
    }

    static void blockSort(int a[]) {
        int floorPowerOfTwo = 1 << (Integer.toBinaryString(a.length).length() - 1);
        // insertion sort blocks of size 2, 4, 8, 16
        for (int width = 2; width <= 16; width *= 2) {
            for (int i = 0; i <= a.length - width; i += width) {
                insertionSort(a, i, i + width);
            }
        }
        // bottom-up merge sort of blocks of 16 - floorPowerOfTwo
        for (int width = 16; width <= floorPowerOfTwo; width *= 2) {
            for (int i = 0; i < a.length - 2 * width; i += 2 * width) {
                // X is a[l, m) and Y is a[m, r)
                int l = i, m = i + width, r = i + 2 * width;
                if (a[r - 1] < a[l]) {
                    // rotate
                    rotate(a, l, r, width);
                } else if (a[m - 1] <= a[m]) {
                    // do nothing, its sorted :D
                } else {
                    // the real block sorting
                    int blockSize = (int) Math.sqrt(width);
                    HashSet<Integer> set = new HashSet<>(); // for unique values
                    // filling the first buffer using rotation
                    int last = l, firstBufferSize = 0;
                    for (int j = l; j < r; j++) {
                        if (set.add(a[j])) {
                            rotate(a, last, j + 1, 1);
                            last++;
                            firstBufferSize++;
                        }
                        if (firstBufferSize == blockSize) {
                            break;
                        }

                    }
                    // filling the last buffer
                    int lastBufferSize = 0;
                    for (int j = r-1; j >= m; j--) {
                        if (set.add(a[j])) {
                            rotate(a, j, r - lastBufferSize, r - lastBufferSize - j);
                            lastBufferSize++;
                        }
                    }
                    // tagging each block
                    for (int ctr=0, j = blockSize+1; j < m; j += blockSize) {
                        swap(a, j, l + ctr);
                        ctr++;
                    }
                    // roll and drop
                    int minX = l + blockSize, idxX = 0;
                    int prevYL = m, prevYR = m;
                    int prevXL = l, prevXR = l;
                    int curYL = m, curYR = m + blockSize;
                    int curXL = l + blockSize, curXR = l + blockSize * 2;
                    while(true) {
                        if((prevYR - prevYL > 0 && a[prevYR-1] >= a[minX]) || curYR - curYL == 0){
                            int pos = binarySearch(a, prevYL, prevYR, a[minX]);
                            int remain = prevYR - minX;
                            // swap minimum X block to beginning of rolling X blocks
                            blockSwap(a, curXL, minX, blockSize);
                            // restore second value for the A block
                            swap(a, curXL+1, l + idxX);
                            idxX++;

                            merge(a, prevXL, prevXR, pos);


                            prevXL = curXL - remain;
                            prevXR = prevXL + blockSize;
                            prevYL = prevXR;
                            prevYR = prevXR + remain;
                            
                            curXL += blockSize;
                            if(m-blockSize <= 0)
                                break;
                            minX = curXL;
                            for(int f=minX + blockSize; f<curXR;f+=blockSize){
                                if ( a[f+1] < a[minX+1]){
                                    minX = f;
                                }
                            }
                        } else if (curYR - curYL < blockSize) {
                            rotate(a, curXL, curYR, curYL - curXL);

                            prevYL = curXL;
                            prevYR = curXL + (curYR - curYL);
                            curXL += (curYR - curYL);
                            curXR += (curYR - curYL);
                            minX += (curYR - curYL);
                            curYR = curYL;
                        } else{
                            blockSwap(a, curXL, curYL, blockSize);
                            prevYL = curXL;
                            prevYR = curXL + blockSize;
                            if(minX == curXL){
                                minX = curXR;
                            }

                            curXL += blockSize;
                            curXR += blockSize;
                            curYL += blockSize;
                            curYR = Math.min(curYR + blockSize, r - lastBufferSize);
                        }
                    }
                    insertionSort(a, r-lastBufferSize, r);
                    merge(a, prevXL, prevXR, r);
                    // merge(a, l, m, r);
                }
                merge(a, l, m, r);
            }
        }
        merge(a, 0, a.length/2, a.length);
    }

    /**
     * merges to adjacent blocks, [left, middle) and [middle, right), together
     *
     * @param a the array to have its blocks merged
     * @param l left index
     * @param m middle index
     * @param r right index
     */
    static void merge(int a[], int l, int m, int r) {
        int buffer[] = new int[r - l], idx = 0, s = l, t = m;
        while (s < m && t < r) {
            if (a[s] <= a[t]) {
                buffer[idx] = a[s];
                s++;
            } else {
                buffer[idx] = a[t];
                t++;
            }
            idx++;
        }
        if (s < m) {
            for (; s < m; s++) {
                buffer[idx] = a[s];
                idx++;
            }
        } else if (t < r) {
            for (; t < r; t++) {
                buffer[idx] = a[t];
                idx++;
            }
        }
        for (int i = 0; i < buffer.length; i++) {
            a[l + i] = buffer[i];
        }
    }

    /**
     * binary seraches for a key within a continuous subarray of an array
     *
     * @param a     the array to be searched
     * @param left  left index of the subarray
     * @param right right index of the subarray
     * @param key   the key we want to find
     * @return the index where the key is or where to insert it
     */
    static int binarySearch(int a[], int left, int right, int key) {
        int l = left, r = right;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] >= key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * swaps two equal length subarrays within an array
     *
     * @param a   array to be block swapped
     * @param x1  starting index of the first subarray
     * @param x2  starting index of the last subarray
     * @param len length of the subarrays to be swapped
     */
    static void blockSwap(int a[], int x1, int x2, int len) {
        for (int i = 0; i < len; i++) {
            swap(a, x1 + i, x2 + i);
        }
    }

    /**
     * rotates a subarray
     *
     * @param a   array with subarray to be rotated
     * @param l   left index of the subarray
     * @param r   right index of the subarray
     * @param cnt how many positions right the subarray is being rotated
     */
    static void rotate(int a[], int l, int r, int cnt) {
        reverse(a, r - cnt, r);
        reverse(a, l, r - cnt);
        reverse(a, l, r);
    }

    /**
     * reverses a subarray
     *
     * @param a array with subarray to be reversed
     * @param l left index of subarray
     * @param r right index of subarray
     */
    static void reverse(int a[], int l, int r) {
        for (int i = 0; i < (r - l) / 2; i++) {
            swap(a, l + i, r - i - 1);
        }
    }

    /**
     * insertion sort of a subarray in an array
     *
     * @param a the array to be sorted
     * @param l the left index of the subarray (inclusive)
     * @param r the right index of the subarray (exclusive)
     */
    static void insertionSort(int a[], int l, int r) {
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        int ctr = 1;
        for (int i = l; i < r; i++) {
            if (buffer.isEmpty()) {
                buffer.add(a[i]);
                continue;
            }
            int insert = buffer.size();
            for (int j = 0; j < buffer.size(); j++) {
                if (buffer.get(j) > a[i]) {
                    insert = j;
                    break;
                }
            }
            buffer.add(insert, a[i]);
        }
        for (int i = 0; i < buffer.size(); i++) {
            a[l + i] = buffer.get(i);
        }
    }

    /**
     * swaps to elements in an array
     *
     * @param a array to have its elements swapped
     * @param i index of first element to be swapped
     * @param j index of second element to be swapped
     */
    static void swap(int a[], int i, int j) {
        int e = a[i];
        a[i] = a[j];
        a[j] = e;
    }
}

