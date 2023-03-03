package Pokemon_Rating;

abstract class AllDataScreen extends Screen{
    public static int DISPLAY_TYPE_ALL = 1;
    public static int DISPLAY_TYPE_BEST = 2;
    protected int displayType;

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }
}
