public class HazardousMap extends Map {
    private static final double WATERTILESPERCENT = 0.3;

    private static HazardousMap instance = null;

    public static HazardousMap getInstance(){
        if(instance == null){
            instance = new HazardousMap();
        }

        return instance;
    }

    public static HazardousMap getInstance(int n){
        if(instance == null){
            instance = new HazardousMap();
        }

        instance.setMapSize(n);

        return instance;
    }

    private HazardousMap() {
        this.WaterTilesPercent = WATERTILESPERCENT;
    }
}

