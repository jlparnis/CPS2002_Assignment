public class SafeMap extends Map {
    private static final double WATERTILESPERCENT = 0.1;

    private static SafeMap instance = null;

    public static SafeMap getInstance(){
        if(instance == null){
            instance = new SafeMap();
        }

        return instance;
    }

    private SafeMap() {
        super();
        this.WaterTilesPercent = WATERTILESPERCENT;
    }

    private SafeMap(int n) {
        super(n);
        this.WaterTilesPercent = WATERTILESPERCENT;
    }
}
