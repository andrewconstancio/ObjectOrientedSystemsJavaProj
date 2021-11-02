import java.util.ArrayList;
import java.util.Arrays;

public class Drawing {
    public static void main(String[] args) {
        String cmd = "";
        ArrayList<Integer> dims = new ArrayList<Integer>();

        HelperFunctions helper = new HelperFunctions();
        for(int i = 0; i < args.length; i++ ) {
            if(!helper.isNumeric(args[i])) {
                cmd += args[i].trim();
            } else {
                dims.add(Integer.parseInt(args[i]));
            }
        }

        System.out.println(dims.get(0));

    }
}