import java.util.ArrayList;

public class Shapes {
    private String color;
    Coordinates coordinates;

    public Shapes(String cmd, ArrayList dims) {
        if(cmd.equals("CREATEREACTANGLE")) {
            int width = (int) dims.get(0);
            int length = (int) dims.get(1);
            Rectangle rectangle = new Rectangle(width, length);
            System.out.printf("here!!!!");
        }

        if(cmd.equals("CREATECIRCLE")) {
            int radius = (int) dims.get(0);
            Circle circle = new Circle(radius);
        }
    }
}
