public class CreateCircle {
    private int radius;
    private String color;
    Coordinates coordinates;

    public CreateCircle(int radius) {
        this.radius = radius;
        this.coordinates = new Coordinates(0 ,0);
        this.color = "Blue";
    }
}
