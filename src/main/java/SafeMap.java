public class SafeMap extends Map {
    private static final double WATERTILESPERCENT = 0.1;

    public SafeMap() {
        super();
        this.WaterTilesPercent = WATERTILESPERCENT;
    }

    public SafeMap(int n) {
        super(n);
        this.WaterTilesPercent = WATERTILESPERCENT;
    }
}
