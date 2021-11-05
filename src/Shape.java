public class Shape {
    private Rectangle rectangle;
    private Circle circle;
    private String color;
    private Coordinates coordinates;

    public Shape(Rectangle rectangle, String color, Coordinates coordinates) {
        this.rectangle = rectangle;
        this.color = color;
        this.coordinates = coordinates;
    }

    public Shape(Circle circle, String color, Coordinates coordinates) {
        this.circle = circle;
        this.color = color;
        this.coordinates = coordinates;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
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

    @Override
    public String toString() {
        return "Shape{" +
                "rectangle=" + rectangle +
                ", circle=" + circle +
                ", color='" + color + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}