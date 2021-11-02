public class CreateRectangle {

    private int width;
    private int height;
    private String color;
    Coordinates coordinates;

    public CreateRectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.color = "Red";
        this.coordinates = new Coordinates(0 ,0);
    }
}
