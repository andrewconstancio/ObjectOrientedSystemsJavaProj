import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Drawing {
    public static int currentSelected = 0;
    public static CommandCaretaker commandCaretaker = new CommandCaretaker();
    public static CommandOriginater commandOriginater = new CommandOriginater();

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        ArrayList<Shape> arrShapes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            String[] cmd = st.split(" ", 4);
            ArrayList<String> arguments = new ArrayList<>();


            if (!cmd[0].equals("UNDO")) {
                //this code fills the linked list with command mementos
                for (int i = 1; i < cmd.length; i++) {
                    arguments.add(cmd[i]);
                }
                commandOriginater.Set(cmd[0], arguments);
                commandCaretaker.addCommandMemento(commandOriginater.StoreInCommandMemento());
            }
            currentSelected = ProcessFunctions.processCmd(cmd[0], arguments, arrShapes, currentSelected);

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