import java.util.ArrayList;
import java.util.LinkedList;

public class CommandOriginater {
    private String function;
    private ArrayList<String> arguments;

    public void Set(String function, ArrayList<String> arguments) {
        this.function = function;
        this.arguments = arguments;
    }

    public CommandMemento StoreInCommandMemento(){
        return new CommandMemento(function, arguments);
    }

    //this function returns linked list
    public LinkedList<CommandMemento> RestoreFromCommandMementoLL(LinkedList<CommandMemento> commandMementos){
        LinkedList<CommandMemento> commands = new LinkedList<>();

        for(int i = 0; i < commandMementos.size(); i++){
            function = commandMementos.get(i).getSavedFunction();
            arguments = commandMementos.get(i).getSavedArguments();
            CommandMemento command = new CommandMemento(function, arguments);
            commands.add(command);
        }
        return commands;
    }
}