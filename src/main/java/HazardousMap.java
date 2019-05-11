public class HazardousMap extends Map {
    private static final double WATERTILESPERCENT = 0.3;

    private static HazardousMap instance = null;

    public static HazardousMap getInstance(){
        if(instance == null){
            instance = new HazardousMap();
        }

        return instance;
    }

    private HazardousMap() {
        super();
        this.WaterTilesPercent = WATERTILESPERCENT;
    }

    private HazardousMap(int n) {
        super(n);
        this.WaterTilesPercent = WATERTILESPERCENT;
    }
}

