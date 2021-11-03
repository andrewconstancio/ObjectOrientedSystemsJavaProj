import java.util.ArrayList;

public class ProccessFunctions {


    public static void processCmd(String[] cmdArr, ArrayList arrShapes, int currentSelcted) {
        String cmd = "";
        ArrayList<Integer> dims = new ArrayList<Integer>();
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
            int selectVal = dims.get(0) - 1;
            if(selectVal >= arrShapes.size()){
                // index does not exists
                System.out.println("ERROR: invalid shape for SELECT");
            }else{
                // index exists
                currentSelcted = selectVal;
            }
        } else if(cmd.contains("COLOR")) {
            String color = cmd.replaceAll("COLOR", "");
            Shapes currShape = (Shapes) arrShapes.get(currentSelcted);
            currShape.setColor(color);
        } else if(cmd.equals("MOVE")) {
            Shapes currShape = (Shapes) arrShapes.get(currentSelcted);
            int setX = dims.get(0);
            int setY = dims.get(1);
            currShape.coordinates.setCoordinates(setX, setY);
        }
    }
}
