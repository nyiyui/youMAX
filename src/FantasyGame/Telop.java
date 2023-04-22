package FantasyGame;

class Telop implements Service {
    private static Telop singleton;

    static Telop current() {
        if (singleton == null) singleton = new Telop();
        return singleton;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    private Character character;
    private int consoleRows = 33;
    private int consoleCols = 60;
    private int prevFrame;
    private String message;
    /**
     * character representing kind of telop. shown on top left and right of the telop
     */
    private char kind;
    private char nextFrame[];
    private String curFrame;

    public void update(int dtms) throws ServiceRemoveException {
        prevFrame += dtms;
        if (prevFrame < 10)
            return;
        prevFrame = 0;
        prepareFrame(dtms);
        String oldFrame = curFrame;
        curFrame = "";
//        curFrame = "+";
//        for (int i = 0; i < consoleCols; i++) {
//            curFrame+="-";
//        }
//        curFrame+="+\n";
        for (int row = 0; row < consoleRows; row++) {
            curFrame += "" + new String(nextFrame).substring(row * consoleCols, (row + 1) * consoleCols);
            curFrame += "\n";
        }
//        curFrame = "+";
//        for (int i = 0; i < consoleCols; i++) {
//            curFrame+="-";
//        }
//        curFrame+="+\n";
        if (oldFrame != null && oldFrame.equals(curFrame)) {
            dtms = 0;
            return;
        }
        System.out.print(curFrame);
    }

    void prepareFrame(int dtms) {
        // yeeeah UTF-16 etc doesn't exist...right???? (ominous smile)
        nextFrame = new char[consoleRows * consoleCols];
        for (int i = 0; i < nextFrame.length; i++)
            nextFrame[i] = '.';
        character.getHere().drawMap(nextFrame, consoleRows, consoleCols);
        String dtLabel = String.format("dt %dms", dtms);
        System.arraycopy(dtLabel.toCharArray(), 0, nextFrame, consoleCols - dtLabel.length(), dtLabel.length());
        String health = String.format("Health: %s%%", character.health);
        System.arraycopy(health.toCharArray(), 0, nextFrame, 0, health.length());
        String gold = String.format("Gold:   %d/%d", character.gold, character.getMaxGold());
        System.arraycopy(gold.toCharArray(), 0, nextFrame, consoleCols, gold.length());
        String loc = String.format("Loc:    %s", character.getHere().getName());
        System.arraycopy(loc.toCharArray(), 0, nextFrame, 2 * consoleCols, loc.length());
        if (message != null) prepareTelop(nextFrame);
    }

    /**
     * Makes sure message is filled to msgRowLen.
     *
     * @param msgRowLen length of the available window to write in.
     * @return preprocessed string.
     */
    String preprocessMessage(int msgRowLen) {
        String res = "";
        int offset = 0;
        for (int i = 0; i < message.length(); i++) {
            int oldI = i;
            i = message.indexOf('\n', i);
            if (i == -1) {
                return message;
            }
            if (i - oldI % msgRowLen == 0) res += message.substring(oldI, i);
            res += message.substring(oldI, i) + new String(new char[msgRowLen - (i - oldI) % msgRowLen]).replaceAll(".", " ");
        }
        return res;
    }

    /**
     * Draws the telop box on the bottom of the frame.
     * this.message must not be null.
     *
     * @param framebuf output buffer
     */
    void prepareTelop(char framebuf[]) {
        assert message != null;
        final int msgRowLen = consoleCols - 6;
        String message = preprocessMessage(msgRowLen);
        final int spaces = 6;
        final int topRow = consoleRows - (2 + spaces);
        final int margin = 1;
        // clear space
        char blank[] = new String(new char[consoleCols]).replaceAll(".", " ").toCharArray();
        for (int row = topRow; row < consoleRows; row++) {
            System.arraycopy(blank, 0, framebuf, row * consoleCols, consoleCols);
        }
        // top and bottom bars
        char topBottom[] = new String(new char[consoleCols]).replaceAll(".", "_").toCharArray();
        System.arraycopy(topBottom, 0, framebuf, topRow * consoleCols + 2, topBottom.length - 4);
        System.arraycopy(topBottom, 0, framebuf, (topRow + spaces) * consoleCols + 2, topBottom.length - 4);
        // left and right bars
        for (int row = topRow + 1; row <= topRow + spaces; row++) {
            int i = row * consoleCols;
            framebuf[i + margin] = '|';
            framebuf[i + consoleCols - 1 - margin] = '|';
        }
        // draw kind (top left and right)
        framebuf[topRow * consoleCols + 1] = kind;
        framebuf[topRow * consoleCols + consoleCols - 2] = kind;
        // message
        int wrote = 0;
        if (message.length() > msgRowLen * (spaces - 1)) {
            int overflowRows = (int) Math.ceil((message.length() - msgRowLen * 3) / (double) msgRowLen);
            // hehe int -> double -> int totally nothing could go wrong...
            wrote = ((int) (Engine.current().getSinceStartNano() / 2000000000) % (overflowRows + 1)) * msgRowLen;
        }
        int row = 0;
        while (wrote < message.length() && row < spaces - 1) {
            int write = Math.min(message.length() - wrote, msgRowLen);
            System.arraycopy(message.toCharArray(), wrote, framebuf, (topRow + 1 + row) * consoleCols + 3, write);
            wrote += write;
            row++;
        }
        // ellipsis
        if (wrote < message.length()) {
            for (int i = 3; i < 6; i++)
                framebuf[(topRow + 3) * consoleCols + consoleCols - i] = '.';
        }
    }

    /**
     * Stop showing the telop.
     */
    public void stopShowing() {
        message = null;
    }

    /**
     * Show a message.
     *
     * @param msg message to show
     */
    public void show(String msg) {
        show(this.kind, msg);
    }

    /**
     * Show a message with a kind.
     *
     * @param kind kind
     * @param msg  message
     */
    public void show(char kind, String msg) {
        this.kind = kind;
        message = msg;
    }
}
