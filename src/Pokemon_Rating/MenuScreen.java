/**
 * Names: Ken Shibata, Youmin Lee, Ivy Zhuang
 * Teacher: Ms. Krasteva
 * Date: March 5, 2023
 * Purpose: displays the menu screen to the user
 */
package Pokemon_Rating;

import java.util.Scanner;

public class MenuScreen extends Screen {
    //TODO: comments? also check if purpose makes sense
    AllDataScreen allDataScreen;

    MenuScreen(AllDataScreen allDataScreen) {
        this.allDataScreen = allDataScreen;
    }

    @Override
    void tick(ScreenManager manager) {
        // this is actually not too good as internationalising this will be a pain...
        System.out.println("    Pokemon* Record Rater");
        System.out.println("    * e is actually an e-acute from [ke] (IPA) (jGRASP bad)\n");
        for (int i=0;i<34;i++)
            System.out.print(" ");
        System.out.println("---\n");
        System.out.println("    Choose an option:");
        System.out.println("      premise - display the premise of the project");
        System.out.println("      all - display all data");
        Scanner s = new Scanner(System.in);
        System.out.println("      best - display \"best\" (as decided by our metrics) Pokemon");
        System.out.println("      bye - exits the Pokemon* Record Rater program");
        InputLoop:
        while (true) {
            System.out.print("> ");
            String line = s.nextLine().toLowerCase();
            int displayType = 0;
            switch (line) {
                case "premise":
                    manager.push(new PremiseScreen());
                    break InputLoop;
                case "all":
                    displayType = AllDataScreen.DISPLAY_TYPE_ALL;
                case "best":
                    if (line.equals("best"))
                        displayType = AllDataScreen.DISPLAY_TYPE_BEST;
                    assert displayType != 0;
                    allDataScreen.setDisplayType(displayType);
                    manager.push(allDataScreen);
                    break InputLoop;
                case "bye":
                    manager.exit();
                    break InputLoop;
                default:
                    System.out.println("Invalid option chosen. Try again.");
                    break;
            }
        }
    }
}