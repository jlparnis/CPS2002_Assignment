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
            playersVisited = new ArrayList<boolean[][]>();
            for(int i = 0; i < players.length; i++) {

                // Get a position that is a grass tile
                Position pos = Position.RandomPosition(mapSize);
                while(map.getTileType(pos) != Map.Tile.GRASS) {
                    pos = Position.RandomPosition(mapSize);
                }

                players[i] = new Player(pos);

                boolean[][] visited = new boolean[mapSize][mapSize];
                playersVisited.add(visited);
            }

            System.out.println(map);

            while(true) {
                askAllPlayers();

                checkPlayerPositions();
            }
        }
    }


    private void askAllPlayers() {
        System.out.println("Enter direction: [U]p, [D]own, [R]ight, [L]eft");
        for(int i = 0; i < playerNo; i++) {
            System.out.print("Player " + (i + 1) +  " ");
            Player.Move move = askMove();

            switch (move) {
                case UP:
                    if(players[i].getPosition().y + 1 < mapSize) {
                        players[i].move(Player.Move.UP);
                    } else {
                        // Invalid move
                        System.out.println("Moving out of map");
                    }

                    break;
                case DOWN:
                    if(players[i].getPosition().y - 1 >= 0) {
                        players[i].move(Player.Move.DOWN);
                    } else {
                        // Invalid move
                        System.out.println("Moving out of map");
                    }

                    break;
                case LEFT:
                    if(players[i].getPosition().x - 1 >= 0) {
                        players[i].move(Player.Move.LEFT);
                    } else {
                        // Invalid move
                        System.out.println("Moving out of map");
                    }

                    break;
                case RIGHT:
                    if(players[i].getPosition().x + 1 < mapSize) {
                        players[i].move(Player.Move.RIGHT);
                    } else {
                        // Invalid move
                        System.out.println("Moving out of map");
                    }

                    break;
                default:
                    throw new RuntimeException("Unknown direction");
            }

        }
    }

    private Player.Move askMove() {
        while(true) {
            System.out.println("direction:");
            String movement = sc.next();

            char move = movement.charAt(0);
            move = Character.toLowerCase(move);

            if(move == 'u') {
                return Player.Move.UP;
            } else if(move == 'd') {
                return Player.Move.DOWN;
            } else if(move == 'l') {
                return Player.Move.LEFT;
            } else if(move == 'r') {
                return Player.Move.RIGHT;
            }

            System.out.println("Enter a valid movement");
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

    private void checkPlayerPositions() {
        for(int i = 0; i < playerNo; i++) {
            System.out.println("Player " + i + 1 + ": " + players[i].getPosition() + ":"+
            map.getTileType(players[i].getPosition()).toString());
        }
    }

    public void generateHTMLFiles(){
        
    }
}

