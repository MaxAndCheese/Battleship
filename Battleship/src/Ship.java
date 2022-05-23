
import java.util.Scanner;

public class Ship {
    private String name;
    private Coordinate[] positions;
    private boolean sunk = false;

    public Ship(ShipType ship) {
        /*
           Destroyer - 2
           Submarine - 3
           Cruiser - 3
           Battleship - 4
           Carrier - 5
        */
        name = ship.getName();
        int size = ship.getSize();
        positions = new Coordinate[size];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a coordinate to place the back of your " + name + " (length of " + size + ")");
        String pos = scan.nextLine();
        int x = Integer.parseInt(pos.substring(1)) - 1;
        int y = Character.toLowerCase(pos.charAt(0)) - 97;
        Coordinate startPosition = new Coordinate(x,y);

        System.out.println("Enter its direction");
        String strDirection = scan.nextLine();
        ShipDirection direction;
        switch(strDirection.substring(0,1).toLowerCase()) {
            case "d":
                direction = ShipDirection.DOWN;
                break;

            case "l":
                direction = ShipDirection.LEFT;
                break;

            case "r":
                direction = ShipDirection.RIGHT;
                break;

            default:
                direction = ShipDirection.UP;
        }

        for (int i = 0; i < size; i++) {
            positions[i] = new Coordinate(startPosition.addCoordinate(direction.getChange(i)));
        }
    }

    public Coordinate[] getPositions() {
        return positions;
    }

    public void checkIfSunk() {
        for (Coordinate c : positions) {
            if (!c.isHit()) return;
        }
        sunk = true;
        System.out.println("You just sunk my " + name);;
    }

    public boolean isSunk() {
        return sunk;
    }
}
