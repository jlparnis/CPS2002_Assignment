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

    public double WaterTilesPercent = 0.3;

    private static Map instance = null;

    public static Map getInstance(){
        if(instance == null){
            instance = new Map();
        }

        return instance;
    }


    public Map(){

    }

    public Map(int n){
        this.size = n;
        map = new Tile[size][size];
    }

    public boolean setMapSize(int n){
        size = n;
        map = new Tile[size][size];
        return true;
    }

    public int getMapSize(){
        return size;
    }

    private Tile getRandomTile() {
        // 30% Water
        // 70% Grass
        if(Math.random() < WaterTilesPercent) {
            return Tile.WATER;
        } else {
            return Tile.GRASS;
        }
    }

    public void generateMap() {
        boolean valid = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = getRandomTile();

                // Make sure that there is at least one Grass tile
                if(map[i][j] == Tile.GRASS) {
                    valid = true;
                }
            }
        }

        Random random = new Random();
        // Set treasure
        int x = random.nextInt(size);
        int y = random.nextInt(size);

        map[x][y] = Tile.TREASURE;

        if(!valid) {
            // No grass tiles preset, .: regenerate the map
            generateMap();
        }
    }

    public Tile getTileType(int x, int y){
        return map[x][y];
    }

    public Tile getTileType(Position pos){
        return map[pos.x][pos.y];
    }

    @Override
    public String toString() {
        StringBuilder m = new StringBuilder();

        for(int j = size - 1; j >= 0; j--) {
            for(int i = 0; i < size; i++) {
                m.append(i + "," + j + " " + map[i][j] + "   \t");
            }
            m.append("\n");
        }

        return m.toString();
    }
}
