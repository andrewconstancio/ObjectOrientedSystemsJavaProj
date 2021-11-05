import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ProcessFunctions {

    public static int processCmd(String function, ArrayList<String> arguments, ArrayList<Shape> arrShapes, int currentSelected) {

        if (function.equals("CREATE")){
            if (arguments.get(0).equals("RECTANGLE")){
                Rectangle newRectangle = new Rectangle(Integer.parseInt(arguments.get(1)), Integer.parseInt(arguments.get(2)));
                Coordinates newCoordinates = new Coordinates(0, 0);
                Shape newShape = new Shape(newRectangle, "Red", newCoordinates);
                arrShapes.add(newShape);
            }
            else if (arguments.get(0).equals("CIRCLE")){
                Circle newCircle = new Circle(Integer.parseInt(arguments.get(1)));
                Coordinates newCoordinates = new Coordinates(0, 0);
                Shape newShape = new Shape(newCircle, "Blue", newCoordinates);
                arrShapes.add(newShape);
            }
        }
        else if(function.equals("SELECT")) {
            int newSelectedShape = Integer.parseInt(arguments.get(0));
            if (newSelectedShape <= arrShapes.size()){
                System.out.println("Shape " + newSelectedShape + " is now selected");
                return newSelectedShape;
            }
            else
                System.out.println("ERROR: invalid shape for SELECT");
        }
        else if(function.equals("COLOR")) {
            String color = arguments.get(0);
            Shape shape = arrShapes.get(currentSelected - 1);

            if (shape == null)
                System.out.println("ERROR: no shape selected");
            else
                shape.setColor(color);
        }
        else if(function.equals("MOVE")) {
            Coordinates coordinates = new Coordinates(Integer.parseInt(arguments.get(0)), Integer.parseInt(arguments.get(1)));
            Shape shape = arrShapes.get(currentSelected - 1);

            if (shape == null)
                System.out.println("ERROR: no shape selected");
            else
                shape.setCoordinates(coordinates);
        }
        else if (function.equals("DRAW")){
            Shape shape = arrShapes.get(currentSelected - 1);

            if (shape == null)
                System.out.println("ERROR: no shape selected");

            if(!(shape.getRectangle() == null)){
                Rectangle r = shape.getRectangle();
                System.out.println("Rectangle, Color: " + shape.getColor() + ", Origin: " + shape.getCoordinates() + ", Width: " + r.getWidth() + ", Height: " + r.getHeight());
            }
            else if(!(shape.getCircle() == null)){
                Circle c = shape.getCircle();
                System.out.println("Circle, Color: " + shape.getColor() + ", Origin: " + shape.getCoordinates() + ", Radius: " + c.getRadius());
            }
        }
        else if (function.equals("DELETE")){
            Shape shape = arrShapes.get(currentSelected - 1);

            if (shape == null)
                System.out.println("ERROR: no shape selected");
            else
                arrShapes.remove(shape);
        }
        else if(function.equals("DRAWSCENE")){

            for(int i = 0; i < arrShapes.size(); i++){
                Shape shape = arrShapes.get(i);

                if(!(shape.getRectangle() == null)){
                    Rectangle r = shape.getRectangle();
                    System.out.println("Rectangle, Color: " + shape.getColor() + ", Origin: " + shape.getCoordinates() + ", Width: " + r.getWidth() + ", Height: " + r.getHeight());
                }
                else if(!(shape.getCircle() == null)){
                    Circle c = shape.getCircle();
                    System.out.println("Circle, Color: " + shape.getColor() + ", Origin: " + shape.getCoordinates() + ", Radius: " + c.getRadius());
                }
            }
        }
        else if(function.equals("UNDO")){
            CommandMemento deletedCommand = Drawing.commandCaretaker.deleteCommandMemento();
            LinkedList<CommandMemento> commandsInOrder = Drawing.getCommandOriginater().RestoreFromCommandMementoLL(Drawing.getCommandCaretaker().getCommandMementos());
            Iterator<CommandMemento> commandsInReverse = commandsInOrder.descendingIterator();

            System.out.println(deletedCommand.getSavedFunction());

            switch (deletedCommand.getSavedFunction()) {
                case "SELECT":
                    //this dont work
                    int previousSelected = 0;

                    while (commandsInReverse.hasNext()) {
                        CommandMemento previousCommand = commandsInReverse.next();

                        if(previousCommand.getSavedFunction().equals("SELECT")){
                            if(currentSelected == 0){
                                previousSelected = processCmd(previousCommand.getSavedFunction(), previousCommand.getSavedArguments(), arrShapes, 0);
                            }
                            System.out.println(previousSelected);
                            return previousSelected;
                        }

                    }
                    //figure out if only good commands go into draw list, because it ain't working with bad commands in there
                    //System.out.println("No Shape Selected");
                    break;
                case "MOVE":
                    //start this
                    int OriginalShape = currentSelected;
                    Shape shape = arrShapes.get(currentSelected - 1);

                    /*
                    while (commandsInReverse.hasNext()) {
                        CommandMemento previousCommand = commandsInReverse.next();

                        if(previousCommand.getSavedFunction().equals("MOVE")){
                            int previousSelected = processCmd(previousCommand.getSavedFunction(), previousCommand.getSavedArguments(), arrShapes, currentSelected);

                            if(previousSelected != 0)
                                return previousSelected;
                        }
                    }
                     */
                    break;
            }
        }
        return currentSelected;
    }
}