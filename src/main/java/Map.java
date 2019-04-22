import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Map {
    enum Tile {
        GRASS, WATER, TREASURE
    }

    private int size;
    private Tile[][] map;

    public Map(){

    }

    public Map(int n){
        this.size = n;
        map = new Tile[size][size];
    }

    public boolean setMapSize(int n){
        size = n;
        return true;
    }

    private Tile getRandomTile() {
        // 40% Grass
        // 60% Water
        if(Math.random() < 0.4) {
            return Tile.GRASS;
        } else {
            return Tile.WATER;
        }
    }

    public void generateMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = getRandomTile();
            }
        }

        Random random = new Random();
        // Set treasure
        int x = random.nextInt(size);
        int y = random.nextInt(size);

        map[x][y] = Tile.TREASURE;
    }

    public char getTileType(int x, int y){
        return ' ';
    }

    @Override
    public String toString() {
        StringBuilder m = new StringBuilder();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                m.append(map[i][j] + "   \t");
            }
            m.append("\n");
        }

        return m.toString();
    }
}
