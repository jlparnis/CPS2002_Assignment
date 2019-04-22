import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int turns;
    private Player[] players;
    private List<boolean[][]> playersVisited;
    private Map map;
    private Scanner sc;
    private int playerNo;
    private int mapSize;

    Game() {
        playersVisited = new ArrayList<boolean[][]>();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.startGame();
    }

    public void startGame(){
        sc = new Scanner(System.in);

        while(true) {
            // Get number of players
            playerNo = askPlayerNumber();

            // Get size of map
            mapSize = askMapSize();

            // Generate map
            map = new Map(mapSize);
            map.generateMap();

            // Create new players
            players = new Player[playerNo];
            for(int i = 0; i < players.length; i++) {

                // Get a position that is a grass tile
                Position pos = Position.RandomPosition(mapSize);
                while(map.getTileType(pos) != Map.Tile.GRASS) {
                    pos = Position.RandomPosition(mapSize);
                }

                players[i] = new Player();

                boolean[][] visited = new boolean[mapSize][mapSize];
                playersVisited.add(visited);
            }

            System.out.println(map);
        }
    }

    private int askPlayerNumber() {
        int play = -1;

        while(true) {
            System.out.println("Players: ");
            if(sc.hasNextInt()) {
                play = sc.nextInt();

                if(play >= 2 && play <= 8) {
                    return play;
                }
            } else {
                // Not an integer
                sc.next();
            }

            System.out.println("Enter number between [x and y]");
        }
    }

    private int askMapSize() {
        int size;
        while(true) {
            System.out.println("Size of map [N x N]: ");
            if(sc.hasNextInt()) {
                size = sc.nextInt();

                if(playerNo <=4) {
                    // playerNo = [2, 4]
                    if(size >= 5 && size <= 50) {
                        return size;
                    }
                } else {
                    // playerNo = [5,8]
                    if(size >= 8 && size <= 50) {
                        return size;
                    }
                }

            } else {

                // Not an integer
                sc.next();
            }

            System.out.println("Enter a valid map number");
        }

    }
    public boolean setNumPlayers(int n){
        return true;
    }

    public void generateHTMLFiles(){
        
    }
}

