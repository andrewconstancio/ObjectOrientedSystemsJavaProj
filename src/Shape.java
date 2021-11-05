import java.util.LinkedList;

public class Shape {
    private Rectangle rectangle;
    private Circle circle;
    private LinkedList<String> colors;
    private LinkedList<Coordinates> coordinates;

    public Shape(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.colors = new LinkedList<String>();
        this.coordinates = new LinkedList<Coordinates>();
    }

    public Shape(Circle circle) {
        this.circle = circle;
        this.colors = new LinkedList<String>();
        this.coordinates = new LinkedList<Coordinates>();
    }

    public LinkedList<String> getColors() {
        return colors;
    }

    public void setColors(LinkedList<String> colors) {
        this.colors = colors;
    }

    public LinkedList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LinkedList<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}