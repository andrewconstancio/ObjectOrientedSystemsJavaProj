import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Drawing {
    public static int currentSelected = 0;
    public static CommandCaretaker commandCaretaker = new CommandCaretaker();
    public static CommandOriginater commandOriginater = new CommandOriginater();

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        ArrayList<Shape> arrShapes = new ArrayList<>();
        ArrayList<Shape> deleteShapes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            String[] cmd = st.split(" ", 4);
            ArrayList<String> arguments = new ArrayList<>(Arrays.asList(cmd).subList(1, cmd.length));

            if (!cmd[0].equals("UNDO")){
                commandOriginater.Set(cmd[0], arguments);
                commandCaretaker.addCommandMemento(commandOriginater.StoreInCommandMemento());
            }

            String color = "Red";
            if(arguments.size() > 0) {
                if (arguments.get(0).equals("CIRCLE")) {
                    color = "Blue";
                }
            }

            currentSelected = ProcessFunctions.processCmd(cmd[0], arguments, 0, 0, color, arrShapes, commandOriginater, commandCaretaker,  deleteShapes, currentSelected);
        }
        //LinkedList<CommandMemento> commandsInOrder = commandOriginater.RestoreFromCommandMementoLL(commandCaretaker.getCommandMementos());
        //System.out.println(commandsInOrder);
    }

    public static CommandCaretaker getCommandCaretaker() {
        return commandCaretaker;
    }

    public static CommandOriginater getCommandOriginater() {
        return commandOriginater;
    }
}