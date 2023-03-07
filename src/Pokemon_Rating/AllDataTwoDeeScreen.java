/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 5, 2023
 * Purpose: displays data using 2D arrays for part 2 of the assignment
 */
package Pokemon_Rating;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

class AllDataTwoDeeScreen extends AllDataScreen {

    private static final int ARRAY_EXTEND_LENGTH = 3;
    private static final int NUM_OF_STATS = 5;

    private static int[][] expandIntArrTo(int arr[][], int idx) {
        if (idx >= arr.length) {
            int[][] arr2 = new int[arr.length + ARRAY_EXTEND_LENGTH][NUM_OF_STATS];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i].clone();
            }
            arr = arr2;
        }
        return arr;
    }

    @Override
    void tick(ScreenManager manager) {
        try (FileReader source = new FileReader("./data.csv")) {
            final BufferedReader r = new BufferedReader(source);
            Pokemon.checkHeader(r);
            Pokemon row = null;
            String[] nameOf = new String[0];
            int stats[][] = new int[0][5]; // 0: ATK, 1: DEF, 2: HP, 3: SPD, 4: AST
            int rowsParsed = 0;
            for (int i = 0; true; i++) {
                row = Pokemon.parseRow(r);
                if (row != null) {
                    String[] nameOf2 = new String[nameOf.length + ARRAY_EXTEND_LENGTH];
                    System.arraycopy(nameOf, 0, nameOf2, 0, nameOf.length);
                    nameOf = nameOf2;
                    nameOf[i] = row.getName();
                    stats = expandIntArrTo(stats, i);
                    stats[i][0] = row.getAttack();
                    stats[i][1] = row.getDefense();
                    stats[i][2] = row.getHp();
                    stats[i][3] = row.getSpeed();
                    stats[i][4] = row.getAesthetic();
                    rowsParsed++;
                } else {
                    break;
                }
            }

            Pokemon finalResult[] = new Pokemon[rowsParsed];
            for (int i = 0; i < finalResult.length; i++) {
                finalResult[i] = new Pokemon(nameOf[i], stats[i][0], stats[i][1], stats[i][2], stats[i][3], stats[i][4]);
            }
            if (this.displayType == AllDataScreen.DISPLAY_TYPE_ALL) {
                System.out.println("NAME____ ATK DEF HP_ SPD AST RTG");
                for (int i = 0; i < rowsParsed; i++) {
                    System.out.printf("%8s %3d %3d %3d %3d %3d %3d\n", nameOf[i], stats[i][0], stats[i][1], stats[i][2], stats[i][3], stats[i][4], finalResult[i].rating());
                }
                manager.pop();
                manager.push(new BufferScreen());
            } else if (this.displayType == AllDataScreen.DISPLAY_TYPE_BEST) {
                String best = "";
                int max = -1;
                for (int i = 0; i < finalResult.length; i++) {
                    if (max < finalResult[i].rating()) {
                        max = finalResult[i].rating();
                        best = finalResult[i].getName();
                    }
                }
                System.out.println(best + " is the BEST POKEMON, with a rating of " + max);
                manager.pop();
                manager.push(new BufferScreen());
            }
        } catch (FileNotFoundException e) {
            System.out.printf("file not found (ensure data.csv is in the working directory): %s", e.getLocalizedMessage());
            manager.pop();
            manager.push(new BufferScreen());
        } catch (IOException e) {
            System.out.printf("reading data file failed: %s", e.getLocalizedMessage());
            manager.pop();
            manager.push(new BufferScreen());
        } catch (ParseException e) {
            System.out.printf("parsing data file failed: %s", e.getLocalizedMessage());
            manager.pop();
            manager.push(new BufferScreen());
        }
    }
}
