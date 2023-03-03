package Pokemon_Rating;

import java.util.Scanner;

public class BufferScreen extends Screen {
    @Override
    void tick(ScreenManager manager) {
        System.out.print("Press enter to continue:");
        new Scanner(System.in).nextLine();
        manager.pop();
    }
}
