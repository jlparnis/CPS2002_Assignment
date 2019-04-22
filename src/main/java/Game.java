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
                visited[pos.x][pos.y] = true;
                playersVisited.add(visited);

            }

            System.out.println(map);

            boolean winners = false;
            while(!winners) {
                // Create all HTML files
                generateHTMLFiles();

                // Get new positions
                askAllPlayers();


                for(int i = 0; i < playerNo; i++) {
                    // Set new position as visited
                    Position pos = players[i].getPosition();
                    playersVisited.get(i)[pos.x][pos.y] = true;

                    // Check if there are any players in water or any winners
                    Map.Tile tile = checkPlayerPositions(i);
                    if(tile == Map.Tile.WATER) {
                        // Change position to starting position
                        players[i].resetStartingPos();
                    } else if (tile == Map.Tile.TREASURE) {
                        // Treasure found
                        winners = true;
                        break;
                    }
                }
            }

            // Winners
            for(int i = 0; i < playerNo; i++) {
                Map.Tile tile = checkPlayerPositions(i);
                if (tile == Map.Tile.TREASURE) {
                    System.out.println("Player " + (i + 1) + " won!");
                }
            }
        }
    }


    private void askAllPlayers() {
        System.out.println("Enter direction: [U]p, [D]own, [R]ight, [L]eft");
        for(int i = 0; i < playerNo; i++) {
            System.out.print("Player " + (i + 1) +  " ");
            Player.Move move = askMove();

            Position currPos = players[i].getPosition();
            switch (move) {
                case UP:
                    if(currPos.y + 1 < mapSize) {
                        players[i].move(Player.Move.UP);
                    } else {
                        // Invalid move
                        System.out.println("Moving out of map");
                    }

                    break;
                case DOWN:
                    if(currPos.y - 1 >= 0) {
                        players[i].move(Player.Move.DOWN);
                    } else {
                        // Invalid move
                        System.out.println("Moving out of map");
                    }

                    break;
                case LEFT:
                    if(currPos.x - 1 >= 0) {
                        players[i].move(Player.Move.LEFT);
                    } else {
                        // Invalid move
                        System.out.println("Moving out of map");
                    }

                    break;
                case RIGHT:
                    if(currPos.x + 1 < mapSize) {
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

            System.err.println("Enter a valid movement");
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

            System.err.println("Error: Enter number of players between 2 and 8");
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

    private Map.Tile checkPlayerPositions(int player) {
        System.out.println("Player 1: " + players[player].getPosition().x + ", " + players[player].getPosition().y);
        return map.getTileType(players[player].getPosition());
    }

    public void generateHTMLFiles(){
        for(int player = 0; player < playerNo; player++) {
            System.out.println("Player 1 position: " + players[player].getPosition().x + ", " + players[player].getPosition().y);


            for(int j = mapSize - 1; j >= 0; j--) {
                for(int i = 0; i < mapSize; i++) {
                    if(playersVisited.get(player)[i][j]) {
                        System.out.print(i + "," + j + " " + map.getTileType(i, j));
                        if(players[player].getPosition().x == i && players[player].getPosition().y == j) {
                            System.out.print("(X)\t");
                        } else {
                            System.out.print("   \t");
                        }
                    } else {
                        System.out.print("............\t");
                    }
                }
                System.out.println();
            }
        }
    }
}

