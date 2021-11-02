import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Drawing {

    public static int currentSelcted;

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String[] cmd = st.split(" ", 4);
            processCmd(cmd);
        }
    }

    public static void processCmd(String[] cmdArr) {
        String cmd = "";
        ArrayList<Integer> dims = new ArrayList<Integer>();
        ArrayList<Shapes> arrShapes = new ArrayList<Shapes>();
        HelperFunctions helper = new HelperFunctions();

        for (String s : cmdArr) {
            if (!HelperFunctions.isNumeric(s)) {
                cmd += s.trim();
            } else {
                dims.add(Integer.parseInt(s));
            }
        }

        if(cmd.equals("CREATERECTANGLE") || cmd.equals("CREATECIRCLE")) {
            Shapes shape = new Shapes(cmd, dims);
            arrShapes.add(shape);
        } else if(cmd.equals("SELECT")) {
            currentSelcted = dims.get(0);
        } else if(cmd.contains("COLOR")) {
            String color = cmd.replaceAll("COLOR", "");
            Shapes currShape = arrShapes.get(currentSelcted);

        }

    }
}