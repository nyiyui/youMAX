package FantasyGame;

abstract class TiledLocation implements Location {
    protected String mapTile;
    protected int offsetRows = 0;
    protected int offsetCols = 0;
    protected Character character;
    protected String message;

    @Override
    public void enter(Character character) {
        this.character=character;
    }

    @Override
    public void exit(Character character) {
        this.character=null;
    }

    @Override
    public void drawMap(char[] framebuffer, int consoleRows, int consoleCols) {
        assert mapTile != null;
        int tileRowWidth = mapTile.indexOf('\n');
        if (tileRowWidth == -1) tileRowWidth = mapTile.length();
        int tileRows = mapTile.length() - mapTile.replaceAll("\n", "").length() + 1;
        for (int row = 0; row < consoleRows; row++) {
            for (int col = 0; col < consoleCols; col++) {
                framebuffer[row * consoleCols + col] = mapTile.charAt((row + offsetRows) % tileRows * (tileRowWidth + 1) + (col + offsetCols) % tileRowWidth);
            }
        }
    }

    @Override
    public String getMessage() {
        return message;
    }
}