public class SafeMap extends Map {
    private static final double WATERTILESPERCENT = 0.1;

    private static SafeMap instance = null;

    public static SafeMap getInstance(){
        if(instance == null){
            instance = new SafeMap();
        }

        return instance;
    }

    public static SafeMap getInstance(int n){
        if(instance == null){
            instance = new SafeMap();
        }
        instance.setMapSize(n);

        return instance;
    }

    private SafeMap() {
        this.WaterTilesPercent = WATERTILESPERCENT;
    }
}
