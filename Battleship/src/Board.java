
public class Board {

    private int rows;
    private int columns;
    private Coordinate[][] board;
    private Ship[] ships;

    public Board(int r, int c, int numShips) {
        rows = r;
        columns = c;
        board = new Coordinate[r][c];
        ships = new Ship[numShips];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Coordinate(j, i);
            }
        }
    }

    public void placeShips() {
        /*
           Destroyer - 2
           Submarine - 3
           Cruiser - 3
           Battleship - 4
           Carrier - 5
        */
        printBoard(true);
        for(int i = 0; i < ships.length / 5; i++) {
            ships[i] = new Ship(ShipType.DESTROYER);
            printBoard(true);
            ships[i + 1] = new Ship(ShipType.SUBMARINE);
            printBoard(true);
            ships[i + 2] = new Ship(ShipType.CRUISER);
            printBoard(true);
            ships[i + 3] = new Ship(ShipType.BATTLESHIP);
            printBoard(true);
            ships [i + 4] = new Ship(ShipType.CARRIER);
            printBoard(true);
        }
    }

    public void generateBoard() {
            for (Ship ship : ships) {
                if(ship != null) {
                    for (Coordinate c : ship.getPositions()) {
                        System.out.println(c.getX());
                        System.out.println(c.getY());
                        board[c.getY()][c.getX()].createShip();
                        if (c.isHit()) board[c.getY()][c.getX()].hit();
                    }
                }
            }
        }

    public void printBoard(boolean revealed) {
        generateBoard();
        System.out.print(" \t");
        for (int i = 1; i <= columns; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == 0) {
                    char letter = (char) (i + 65);
                    System.out.print(letter + "\t");
                }
                Coordinate c = board[i][j];
                if(c.isShip() && (c.isHit() || revealed)) {
                    if (!getShipFromPos(c.getX(), c.getY()).isSunk()) {
                        if(c.isHit()) System.out.println("[X]");
                        else System.out.print("[ ]\t");
                    }
                    else System.out.print(" - \t");
                }
                else if (c.isHit()) System.out.print(" O \t");
                else System.out.print(" - \t");
            }
            System.out.println();
        }
    }

    public Ship getShipFromPos(int x, int y) {
        //IMPERATIVE

        for (Ship ship : ships) {
            if (ship != null) {
                for (Coordinate c : ship.getPositions()) {
                    if (c.getX() == x && c.getY() == y) {
                        return ship;
                    }
                }
            }
        }
        return null;


        //DECLARATIVE
        /*
        return Arrays.stream(ships)
                .filter(s -> s != null)
                .filter(s ->
                        Arrays.stream(s.getPositions())
                                .anyMatch(c -> c.getX() == x && c.getY() == y)
                )
                .findFirst().get();
         */
    }

    public boolean lost() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) return false;
        }
        return true;
    }

    public Coordinate[][] getBoard() {
        return board;
    }
}
