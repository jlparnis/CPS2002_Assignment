public class SafeMapCreator {

    public Map creator(){
        return SafeMap.getInstance();
    }

    public Map creator(int n){
        return SafeMap.getInstance(n);
    }
}