import java.util.ArrayList;

public class CommandMemento {
    private String function;
    private ArrayList<String> arguments;

    public CommandMemento(String function, ArrayList<String> arguments) {
        this.function = function;
        this.arguments = arguments;
    }

    public String getSavedFunction() {
        return function;
    }

    public ArrayList<String> getSavedArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return function + " " + arguments + "\n";
    }
}