import java.util.ArrayList;

public class Shapes {

    public Rectangle rectangle;
    public Circle circle;
    public String color;
    public Coordinates coordinates;

    public Shapes(String cmd, ArrayList dims) {

        if(cmd.equals("CREATERECTANGLE")) {
            int width = (int) dims.get(0);
            int length = (int) dims.get(1);
            this.rectangle = new Rectangle(width, length);
            this.coordinates = new Coordinates(0, 0);
            this.color = "RED";
        }

        if(cmd.equals("CREATECIRCLE")) {
            int radius = (int) dims.get(0);
            this.circle = new Circle(radius);
            this.coordinates = new Coordinates(0, 0);
            this.color = "BLUE";
        }
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
}
