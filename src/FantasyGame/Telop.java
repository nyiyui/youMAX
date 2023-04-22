package FantasyGame;

import java.util.ArrayDeque;

class Telop implements Service {
    private static Telop singleton;

    static Telop current() {
        if (singleton == null) singleton = new Telop();
        return singleton;
    }

    private Elf elf;
    private int consoleRows = 50;
    private int consoleCols = 10;
    private int prevFrame;
    private ArrayDeque<String> telops;
    private char nextFrame[];
    private String curFrame;

    public void update(int dtms) throws ServiceRemoveException {
        prevFrame += dtms;
        if (prevFrame < 200)
            return;
        prevFrame = 0;
        prepareFrame(dtms);
        String oldFrame = curFrame;
        curFrame = "";
        for (int row = 0; row < consoleCols; row++) {
            curFrame += new String(nextFrame).substring(row * consoleRows, row * consoleRows + consoleCols);
            curFrame += "\n";
        }
        if (oldFrame != null&& oldFrame.equals(curFrame)){
            dtms = 0;
            return;
        }
        System.out.print(curFrame);
    }

    void prepareFrame(int dtms) {
        // yeeeah UTF-16 etc doesn't exist...right???? (ominous smile)
        nextFrame = new char[consoleRows * consoleCols];
        for (int i = 0; i < nextFrame.length; i++)
            nextFrame[i] = ' ';
        String date = String.format("dt %dms", dtms);
        System.arraycopy(date.toCharArray(), 0, nextFrame, consoleRows - date.length(), date.length());
    }

    public void show(String msg) {
        telops.add(msg);
    }
}
