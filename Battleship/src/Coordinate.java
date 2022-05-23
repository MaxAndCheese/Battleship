
public class Coordinate {

    private int x;
    private int y;
    private boolean hit = false;
    private boolean isShip = false;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate c) {
        x = c.getX();
        y = c.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isHit() {
        return hit;
    }

    public void hit() {
        hit = true;
    }

    public boolean isShip() {
        return isShip;
    }

    public void createShip() {
        isShip = true;
    }

    public Coordinate addCoordinate(Coordinate c) {
        return new Coordinate(this.x + c.getX(),this.y + c.getY());
    }

}
