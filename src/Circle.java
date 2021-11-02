public class Circle {
    private int radius;
    private String color;
    Coordinates coordinates;

    public Circle(int radius) {
        this.radius = radius;
        this.coordinates = new Coordinates(0 ,0);
        this.color = "Blue";
    }
}
