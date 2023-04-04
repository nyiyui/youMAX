package BlockSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Block_Sort {

    public static void main(String[] args) {
        int a[] = {5, 4, 1, 7, 10, 20, 4, 100, 54, 12, 3, 18, 45, 23, 1, 4, 13, 8, 7, 19, 99, 2, 67, 34, 69, 11, 5, 73,
                23, 10, 35, 17};
        blockSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void blockSort(int a[]) {
        int floorPowerOfTwo = 1 << (Integer.toBinaryString(a.length).length() - 1);
        // insertion sort blocks of size 2, 4, 8, 16
        for (int width = 2; width <= 16; width *= 2) {
            for (int i = 0; i < a.length - width; i += width) {
                insertionSort(a, i, i + width);
            }
        }
        // merge sort of blocks of 16 - ...
        for (int width = 16; width <= floorPowerOfTwo; width *= 2) {
            for (int i = 0; i < a.length; i += 2 * width) {
                // X is a[l, m) and Y is a[m, r)
                int l = i, m = Math.min(i + width, a.length - 1), r = Math.min(i + 2 * width, a.length);
                if (a[r - 1] < a[l]) {
                    // rotate
                    rotate(a, l, r, width);
                } else if (a[m - 1] <= a[m]) {
                    // do nothing, its sorted :D
                } else {
                    // the real block sorting
                    int blockSize = (int) Math.sqrt(width);
                    HashSet<Integer> set = new HashSet<Integer>(); // for unique values
                    // filling the first buffer using rotation
                    int last = l, firstBufferSize = 0;
                    for (int j = l; j < r; j++) {
                        if (set.add(a[j])) {
                            rotate(a, last, j + 1, 1);
                            last = j + 1;
                            firstBufferSize++;
                        }
                        if (firstBufferSize == blockSize) {
                            break;
                        }
                    }
                    // filling the last buffer
                    int lastBufferSize = 0;
                    for (int j = r - 1; j > m; j--) {
                        if (set.add(a[j])) {
                            rotate(a, j, r - lastBufferSize, r - lastBufferSize - j - 1);
                            lastBufferSize++;
                        }
                    }
                    // tagging each block
                    int ctr = 0; // counter for num of blocks that we've iterated thru
                    for (int j = firstBufferSize; j < m - l; j += blockSize) {
                        swap(a, j, r - lastBufferSize + ctr);
                        ctr++;
                    }
                    int min = l;
                    for (int j = 0; j < blockSize; j++) {
                        // merge Block with min(A) (using U as a buffer)
                        for (int k = 1; k < blockSize; k++) {
                            blockSwap(a, Math.min(l + k * blockSize, a.length - 1),
                                    Math.min(m + k * blockSize, a.length - 1), blockSize);
                            if (a[min] <= a[m + k * (blockSize - 1) - 1]) {
                                int pos = binarySearch(a, m + k * blockSize, m + k * (blockSize + 1), a[min]);
                                rotate(a, pos, m + k * (blockSize + 1), m + k * (blockSize + 1) - pos - 1 );
                                min++;
                            }
                        }
                        // merge current block with previous block
                        if (j > 0) {
                            merge(a, l + j * (blockSize - 1), l + j * (blockSize), l + j * (blockSize + 1));
                        }
                    }
                    insertionSort(a, r - lastBufferSize, r);
                    insertionSort(a, l, m);
                    merge(a, l, m, r);
                }
            }
        }
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

