
public enum ShipDirection {

    UP(new Coordinate(0, -1)),
    DOWN(new Coordinate(0, 1)),
    LEFT(new Coordinate(-1, 0)),
    RIGHT(new Coordinate(1,0));

    private Coordinate change;

    ShipDirection(Coordinate c) {
        change = c;
    }

    public Coordinate getChange(int i) {
        return new Coordinate(change.getX() * i, change.getY() * i);
    }
}
