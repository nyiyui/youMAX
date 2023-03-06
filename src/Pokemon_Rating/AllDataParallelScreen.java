/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 5, 2023
 * Purpose:
 */
package Pokemon_Rating;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

class AllDataParallelScreen extends AllDataScreen {
    //TODO: add to purpose in top comments
    private static final int ARRAY_EXTEND_LENGTH = 3;

    private static int[] expandIntArrTo(int arr[], int i) {
        if (i >= arr.length) {
            int[] arr2 = new int[arr.length + ARRAY_EXTEND_LENGTH];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
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
            int[] attackOf = new int[0];
            int[] defenseOf = new int[0];
            int[] hpOf = new int[0];
            int[] speedOf = new int[0];
            int[] aestheticOf = new int[0];
            int rowsParsed = 0;
            for (int i = 0; true; i++) {
                row = Pokemon.parseRow(r);
                if (row != null) {
                    String[] nameOf2 = new String[nameOf.length + ARRAY_EXTEND_LENGTH];
                    System.arraycopy(nameOf, 0, nameOf2, 0, nameOf.length);
                    nameOf = nameOf2;
                    nameOf[i] = row.getName();
                    attackOf = expandIntArrTo(attackOf, i);
                    attackOf[i] = row.getAttack();
                    defenseOf = expandIntArrTo(defenseOf, i);
                    defenseOf[i] = row.getDefense();
                    hpOf = expandIntArrTo(hpOf, i);
                    hpOf[i] = row.getHp();
                    speedOf = expandIntArrTo(speedOf, i);
                    speedOf[i] = row.getSpeed();
                    aestheticOf = expandIntArrTo(aestheticOf, i);
                    aestheticOf[i] = row.getAesthetic();
                    rowsParsed++;
                } else {
                    break;
                }
            }
            Pokemon finalResult[] = new Pokemon[hpOf.length];
            for (int i = 0; i < finalResult.length; i++) {
                finalResult[i] = new Pokemon(nameOf[i], attackOf[i], defenseOf[i], hpOf[i], speedOf[i], aestheticOf[i]);
            }
            if (this.displayType == AllDataScreen.DISPLAY_TYPE_ALL) {
                System.out.println("NAME____ ATK DEF HP_ SPD AST RTG");
                for (int i = 0; i < rowsParsed; i++) {
                    System.out.printf("%8s %3d %3d %3d %3d %3d %3d\n", nameOf[i], attackOf[i], defenseOf[i], hpOf[i], speedOf[i], aestheticOf[i], finalResult[i].rating());
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
        manager.pop();
    }
}
