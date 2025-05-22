import java.awt.*;
import java.util.stream.Stream;
import java.util.Scanner;

public class MainApp {
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
    public static void add(){
        System.out.println("ADDING...");
    }
    public static void save(){
        System.out.println("SAVING...");
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
                    add();
            }
        }
    }
    public static void main(String[] args) {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        //1. PROMPT FOR SIZE
        int size = promptInt("Size", 400);

        // The world is your canvas
        World world = new World(size, size);
        Turtle turtle = new Turtle(world, size * -0.5, size * -0.5);

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
