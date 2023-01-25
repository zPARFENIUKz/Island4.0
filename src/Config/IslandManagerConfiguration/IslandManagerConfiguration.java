package Config.IslandManagerConfiguration;

public class IslandManagerConfiguration {
    protected final int verticalLocationsCount;
    protected final int horizontalLocationsCount;
    protected final boolean isCycleDuringSomebodyALive;
    protected final int cycleCount;
    protected final int delayBetweenCyclesMillis;

    public IslandManagerConfiguration(int verticalLocationsCount, int horizontalLocationsCount, boolean isCycleDuringSomebodyALive, int cycleCount, int delayBetweenCyclesMillis) {
        this.verticalLocationsCount = verticalLocationsCount;
        this.horizontalLocationsCount = horizontalLocationsCount;
        this.isCycleDuringSomebodyALive = isCycleDuringSomebodyALive;
        this.cycleCount = cycleCount;
        this.delayBetweenCyclesMillis = delayBetweenCyclesMillis;
    }

    public int getVerticalLocationsCount() {
        return verticalLocationsCount;
    }

    public int getHorizontalLocationsCount() {
        return horizontalLocationsCount;
    }

    public boolean getIsCycleDuringSomebodyALive() {
        return isCycleDuringSomebodyALive;
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public int getDelayBetweenCyclesMillis() {
        return delayBetweenCyclesMillis;
    }

}
