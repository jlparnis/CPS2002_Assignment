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
            // players: [2, 8]
            // size:


            // Get number of players
            while(true) {
                System.out.println("Players: ");
                if(sc.hasNextInt()) {
                    playerNo = sc.nextInt();

                    if(playerNo >= 2 && playerNo <= 8) {
                        break;
                    }
                } else {
                    // Not an integer
                    sc.next();
                }

                System.out.println("Enter number between [x and y]");
            }


            // Get number of players
            while(true) {
                System.out.println("Size of map [N x N]: ");
                if(sc.hasNextInt()) {
                    mapSize = sc.nextInt();

                    if(playerNo <=4) {
                        // playerNo = [2, 4]
                        if(mapSize >= 5 && mapSize <= 50) {
                            break;
                        }
                    } else {
                        // playerNo = [5,8]
                        if(mapSize >= 8 && mapSize <= 50) {
                            break;
                        }
                    }

                } else {

                    // Not an integer
                    sc.next();
                }

                System.out.println("Enter a valid map number");
            }

            System.out.println(playerNo);
        }
    }

    public boolean setNumPlayers(int n){
        return true;
    }

    public void generateHTMLFiles(){
        
    }
}

