
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    private static Board p1;
    private static Board p2;

    public static void main(String... args) throws InterruptedException {

        p1 = new Board(10,10, 5);
        p2 = new Board(10,10, 5);

        placeShipsForPlayers();

        while (!p1.lost() && !p2.lost()) {
            turn(p1, p2, 1);
            clearPrintMenu();
            turn(p2, p1, 2);
            clearPrintMenu();
        }

        if (p2.lost()) System.out.println("Player 1 wins!");
        else System.out.println("Player 2 wins!");
    }

    private static void turn(Board player, Board otherPlayer, int playerNum) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player " + playerNum + "'s turn, showing player one's board in");
        countdown(5);
        player.printBoard(false);
        System.out.println("Enter a coordinate to hit");
        String pos = scan.nextLine();
        int x = Integer.parseInt(pos.substring(1)) - 1;
        int y = Character.toLowerCase(pos.charAt(0)) - 97;
        Coordinate hitCoord = otherPlayer.getBoard()[y][x];
        hitCoord.hit();
        if (hitCoord.isShip()) {
            System.out.println("You hit!");
            otherPlayer.getShipFromPos(x,y).checkIfSunk();
        }
        else System.out.println("You missed");
    }

    private static void placeShipsForPlayers() throws InterruptedException {
        System.out.println("Player 1, place your ships");
        p1.placeShips();
        System.out.println("Player 2 placing ships in");
        countdown(3);
        clearPrintMenu();
        System.out.println("Player 2, place your ships");
        p2.placeShips();
        TimeUnit.SECONDS.sleep(3);
        clearPrintMenu();
    }

    private static void countdown(int seconds) throws InterruptedException {
        for (int i = seconds; i > 0; i--) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void clearPrintMenu() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
