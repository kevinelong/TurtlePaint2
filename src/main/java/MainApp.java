import java.util.Scanner;

public class MainApp {
    private static Turtle turtle;
    private static World world;

    public static String prompt(String message, String defaultValue) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        System.out.printf("%s (%s): ", message, defaultValue);
        name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            name = defaultValue;
        }
        return name;
    }

    public static int promptInt(String message, Integer defaultValue) {
        Integer i = null;
        while (i == null) {
            String text = prompt(message, defaultValue.toString());
            try {
                i = Integer.parseInt(text);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return i;
    }
    public static void addSquare(){
        System.out.println("Adding Square");
        int width = promptInt("Side Length", 50);

        int borderWidth = promptInt("Border Width", 5);
        int x = promptInt("horizontal x position", 0);
        int y = promptInt("vertical y position", 0);
        String color = prompt("Color", "green");

        Shape s = new Square(turtle, x,y, color, borderWidth, width);
        s.draw();
    }
    public static void addCircle(){
        System.out.println("Adding Circle");
        int width = promptInt("Radius", 25);

        int borderWidth = promptInt("Border Width", 5);
        int x = promptInt("horizontal x position", 0);
        int y = promptInt("vertical y position", 0);
        String color = prompt("Color", "green");

        Shape s = new Circle(turtle, x,y, color, borderWidth, width);
        s.draw();
    }
    public static void addTriangle(){
        System.out.println("Adding Triangle");
        int width = promptInt("Side Length", 50);

        int borderWidth = promptInt("Border Width", 5);
        int x = promptInt("horizontal x position", 0);
        int y = promptInt("vertical y position", 0);
        String color = prompt("Color", "green");

        Shape s = new Triangle(turtle, x,y, color, borderWidth, width);
        s.draw();
    }
    public static void shapeMenu(){
        System.out.println("ADD SHAPE MENU");
        int choice = -1;
        while (choice != 0) {
            System.out.println("1) - Square \n 2) - Circle \n 3) - Triangle \n 0) - Back to Main");
            choice = promptInt("Enter choice", 1);
            switch (choice) {
                case 0:
                    return;
                case 2:
                    addCircle();
                    break;
                case 3:
                    addTriangle();
                    break;
                default: // 1) - Add
                    addSquare();
            }
        }
    }
    public static void save(){
        System.out.println("SAVING...");
        String directory = System.getProperty("user.dir");
        String fileName = prompt("File Name", "myfile.png");
        world.saveAs(directory + "/" + fileName);
    }
    public static void mainMenu(){
        int choice = -1;
        while (choice != 0) {
            System.out.println("1) - Add \n 2) - Save \n 0) - Exit");
            choice = promptInt("Enter choice", 1);
            switch (choice) {
                case 0:
                    return;
                case 2:
                    save();
                    break;
                default: // 1) - Add
                    shapeMenu();
            }
        }
    }
    public static void main(String[] args) {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        //1. PROMPT FOR SIZE
        int size = promptInt("Size", 400);

        // The world is your canvas
        world = new World(size, size);
        turtle = new Turtle(world, size * -0.5, size * -0.5);

        mainMenu();

        System.out.println("BYE BYE");
//        var list = Stream.of(
//                new Square(turtle, -100, 0, "GREEN", 6, 100),
//                new Triangle(turtle, 0, 0, "BLACK", 6, 100),
//                new Circle(turtle, 100, 0, "MAGENTA", 6, 100)
//        );
//        list.forEach(Shape::draw);

//
//        Shape s1 = new XShape(turtle, -200,0,"GREEN", 6, 100, 100);
//        s1.draw();
    }
}
