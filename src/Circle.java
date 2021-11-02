public class Circle {
    public int radius;
    public String color;
    public Coordinates coordinates;

    public Circle(int radius) {
        this.radius = radius;
        this.coordinates = new Coordinates(0 ,0);
        this.color = "Blue";
    }
}
