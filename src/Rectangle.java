public class Rectangle {

    public int width;
    public int height;
    public String color;
    public Coordinates coordinates;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.color = "Red";
        this.coordinates = new Coordinates(0 ,0);
    }

    public void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x ,y);
    }
}
