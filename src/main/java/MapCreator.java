public class MapCreator {

    public Map create(Game.MapType type){
        Map map = null;

        switch(type){
            case SAFE:
                SafeMapCreator safeMapCreator = new SafeMapCreator();
                map = safeMapCreator.creator();
                break;
            case HAZARDOUS:
                HazardousMapCreator hazardousMapCreator = new HazardousMapCreator();
                map = hazardousMapCreator.creator();
                break;
            default:
                throw new RuntimeException("Unsupported map type");
        }

        return map;
    }

    public Map create(Game.MapType type, int n){
        Map map = null;

        switch(type){
            case SAFE:
                SafeMapCreator safeMapCreator = new SafeMapCreator();
                map = safeMapCreator.creator(n);
                break;
            case HAZARDOUS:
                HazardousMapCreator hazardousMapCreator = new HazardousMapCreator();
                map = hazardousMapCreator.creator(n);
                break;
            default:
                throw new RuntimeException("Unsupported map type");
        }

        return map;
    }
}
