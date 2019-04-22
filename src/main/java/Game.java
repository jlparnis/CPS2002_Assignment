import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private int turns;
    private Player[] players;
    private Map map;
    private Scanner sc;
    private int playerNo;
    private int mapSize;

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


            map = new Map(mapSize);

            map.generateMap();

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

