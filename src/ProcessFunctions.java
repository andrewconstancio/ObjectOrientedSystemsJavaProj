import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ProcessFunctions {

    public static int processCmd(String function, ArrayList<String> arguments, ArrayList<Shape> arrShapes, int currentSelected) {

        if (function.equals("CREATE")){
            if (arguments.get(0).equals("RECTANGLE")){
                Rectangle newRectangle = new Rectangle(Integer.parseInt(arguments.get(1)), Integer.parseInt(arguments.get(2)));
                Coordinates newCoordinates = new Coordinates(0, 0);
                Shape newShape = new Shape(newRectangle);
                newShape.getColors().add("Red");
                newShape.getCoordinates().add(newCoordinates);
                arrShapes.add(newShape);
            }
            else if (arguments.get(0).equals("CIRCLE")){
                Circle newCircle = new Circle(Integer.parseInt(arguments.get(1)));
                Coordinates newCoordinates = new Coordinates(0, 0);
                Shape newShape = new Shape(newCircle);
                newShape.getColors().add("Blue");
                newShape.getCoordinates().add(newCoordinates);
                arrShapes.add(newShape);
            }
        }
        else if(function.equals("SELECT")) {
            int newSelectedShape = Integer.parseInt(arguments.get(0));
            if (newSelectedShape > 0 && newSelectedShape <= arrShapes.size())
                return newSelectedShape;
            else
                System.out.println("ERROR: invalid shape for SELECT");
        }
        else if(function.equals("COLOR")) {
            if (currentSelected == 0){
                System.out.println("ERROR: no shape selected");
                return 0;
            }
            Shape shape = arrShapes.get(currentSelected - 1);
            String color = arguments.get(0);
            shape.getColors().add(color);
        }
        else if(function.equals("MOVE")) {
            if (currentSelected == 0){
                System.out.println("ERROR: no shape selected");
                return 0;
            }
            Shape shape = arrShapes.get(currentSelected - 1);
            Coordinates coordinates = new Coordinates(Integer.parseInt(arguments.get(0)), Integer.parseInt(arguments.get(1)));
            shape.getCoordinates().add(coordinates);
        }
        else if (function.equals("DRAW")){
            if (currentSelected == 0){
                System.out.println("ERROR: no shape selected");
                return 0;
            }
            Shape shape = arrShapes.get(currentSelected - 1);

            if(!(shape.getRectangle() == null)){
                Rectangle r = shape.getRectangle();
                LinkedList<String> colorHistory = shape.getColors();
                LinkedList<Coordinates> coordinateHistory = shape.getCoordinates();
                System.out.println("Rectangle, Color: " + colorHistory.getLast() + ", Origin: " + coordinateHistory.getLast() + ", Width: " + r.getWidth() + ", Height: " + r.getHeight());
            }
            else if(!(shape.getCircle() == null)){
                Circle c = shape.getCircle();
                LinkedList<String> colorHistory = shape.getColors();
                LinkedList<Coordinates> coordinateHistory = shape.getCoordinates();
                System.out.println("Circle, Color: " + colorHistory.getLast() + ", Origin: " + coordinateHistory.getLast() + ", Radius: " + c.getRadius());
            }
        }
        else if (function.equals("DELETE")){
            if (currentSelected == 0){
                System.out.println("ERROR: no shape selected");
                return 0;
            }
            Shape shape = arrShapes.get(currentSelected - 1);
            arrShapes.remove(shape);
            return 0;
        }
        else if(function.equals("DRAWSCENE")){

            for (Shape shape : arrShapes) {
                LinkedList<String> colorHistory = shape.getColors();
                LinkedList<Coordinates> coordinateHistory = shape.getCoordinates();

                if (!(shape.getRectangle() == null)) {
                    Rectangle r = shape.getRectangle();
                    System.out.println("Rectangle, Color: " + colorHistory.getLast() + ", Origin: " + coordinateHistory.getLast() + ", Width: " + r.getWidth() + ", Height: " + r.getHeight());
                } else if (!(shape.getCircle() == null)) {
                    Circle c = shape.getCircle();
                    System.out.println("Circle, Color: " + colorHistory.getLast() + ", Origin: " + coordinateHistory.getLast() + ", Radius: " + c.getRadius());
                }
            }
        }
        else if(function.equals("UNDO")){
            CommandMemento deletedCommand = Drawing.commandCaretaker.deleteCommandMemento();
            LinkedList<CommandMemento> commandsInOrder = Drawing.getCommandOriginater().RestoreFromCommandMementoLL(Drawing.getCommandCaretaker().getCommandMementos());
            Iterator<CommandMemento> commandsInReverse = commandsInOrder.descendingIterator();
            Shape shape;

            switch (deletedCommand.getSavedFunction()) {
                case "SELECT":
                    while (commandsInReverse.hasNext()) {
                        CommandMemento previousCommand = commandsInReverse.next();

                        if(previousCommand.getSavedFunction().equals("SELECT")){
                            int newSelectedShape = processCmd(previousCommand.getSavedFunction(), previousCommand.getSavedArguments(), arrShapes, 0);
                            if (newSelectedShape > 0 && newSelectedShape <= arrShapes.size())
                                return newSelectedShape;
                        }
                    }
                    System.out.println("No Shape Selected");
                    break;
                case "MOVE":
                    if (currentSelected == 0){
                        System.out.println("ERROR: no shape selected");
                        return 0;
                    }
                    shape = arrShapes.get(currentSelected - 1);
                    shape.getCoordinates().removeLast();
                    break;
                case "COLOR":
                    if (currentSelected == 0){
                        System.out.println("ERROR: no shape selected");
                        return 0;
                    }
                    shape = arrShapes.get(currentSelected - 1);
                    shape.getColors().removeLast();
                    break;
                case "CREATE":

                    break;
                case "DELETE":

                    break;
                default:
                    //Undoing DRAW or DRAWSCENE has no effect
            }
        }
        return currentSelected;
    }
}