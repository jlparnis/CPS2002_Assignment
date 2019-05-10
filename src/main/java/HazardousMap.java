public class HazardousMap extends Map {
    private static final double WATERTILESPERCENT = 0.3;

    public HazardousMap() {
        super();
        this.WaterTilesPercent = WATERTILESPERCENT;
    }

    public HazardousMap(int n) {
        super(n);
        this.WaterTilesPercent = WATERTILESPERCENT;
    }
}

