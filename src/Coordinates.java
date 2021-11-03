public class Coordinates {

    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String getCoordinates() {
        return String.valueOf(this.x) + "," + String.valueOf(this.y);
    }
}
