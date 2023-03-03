package Pokemon_Rating;

public class PremiseScreen extends Screen{
    @Override
    void tick(ScreenManager manager) {
        System.out.println("Premise:");
        // TODO: print premise
        manager.pop();
    }
}
