import java.util.ArrayList;

public class Shapes {

    public Rectangle rectangle;
    public Circle circle;

    public Shapes(String cmd, ArrayList dims) {

        if(cmd.equals("CREATERECTANGLE")) {
            int width = (int) dims.get(0);
            int length = (int) dims.get(1);
            this.rectangle = new Rectangle(width, length);
        }

        if(cmd.equals("CREATECIRCLE")) {
            int radius = (int) dims.get(0);
            this.circle = new Circle(radius);
        }

    }
}
