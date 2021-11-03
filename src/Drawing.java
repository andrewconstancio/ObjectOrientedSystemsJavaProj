import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Drawing {

    public static int currentSelcted;

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        ArrayList<Shapes> arrShapes = new ArrayList<Shapes>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String[] cmd = st.split(" ", 4);
            ProccessFunctions.processCmd(cmd, arrShapes, currentSelcted);
        }
    }
}