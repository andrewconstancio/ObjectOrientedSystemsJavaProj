import java.io.File;
import java.util.ArrayList;


public class Drawing {
    public static void main(String[] args) {
        String cmd = "";
        HelperFunctions helper = new HelperFunctions();
        for(int i = 0; i < args.length; i++ ) {
            if(!helper.isNumeric(args[i])) {
                cmd += args[i].trim();
            }
        }

        if(cmd.equals("CREATEREACTANGLE")) {
            CreateRectangle rectangle = new CreateRectangle(4, 2);
            System.out.printf("here!!!!");
        }

        if(cmd.equals("CREATECIRCLE")) {
            CreateCircle circle = new CreateCircle(5);
        }
    }
}