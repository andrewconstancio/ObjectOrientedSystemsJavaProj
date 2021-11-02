public class Rectangle {

    private int width;
    private int height;
    private String color;
    Coordinates coordinates;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.color = "Red";
        this.coordinates = new Coordinates(0 ,0);
    }
}
