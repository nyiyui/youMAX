package Pokemon_Rating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainPartTwo {
    public static void main(String[] args) {
        ScreenManager m = new ScreenManager();
        m.push(new MenuScreen(new AllDataParallelScreen()));
        m.run();
    }
}
