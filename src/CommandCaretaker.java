import java.util.LinkedList;

public class CommandCaretaker {
    public static LinkedList<CommandMemento> savedCommands = new LinkedList<>();

    public void addCommandMemento(CommandMemento command){
        savedCommands.add(command);
    }

    public CommandMemento deleteCommandMemento(){
        return savedCommands.removeLast();
    }

    public LinkedList<CommandMemento> getCommandMementos(){
        return savedCommands;
    }
}
