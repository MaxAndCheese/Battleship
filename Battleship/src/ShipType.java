
public enum ShipType {

    DESTROYER("Destroyer", 2),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    BATTLESHIP("Battleship", 4),
    CARRIER("Carrier", 5);

    private String name;
    private int size;

    ShipType(String n, int s) {
        name = n;
        size = s;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
