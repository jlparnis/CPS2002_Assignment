public class HazardousMapCreator {

    public Map creator(){
        return HazardousMap.getInstance();
    }

    public Map creator(int n){
        return HazardousMap.getInstance(n);
    }
}
