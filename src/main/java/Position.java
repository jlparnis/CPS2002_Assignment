import java.util.Random;

public class Position {
    public int x;
    public int y;

    public Position(){}

    public static Position RandomPosition(int size) {
        Random random = new Random();
        Position pos = new Position();

        pos.x = random.nextInt(size);
        pos.y = random.nextInt(size);

        return pos;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return ("(" + x + ", " + y + ")");
    }
}
