import java.awt.*;
import java.util.stream.Stream;

public class MainApp
{
    public static void main(String[] args)
    {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
        World world = new World(400, 400);
        Turtle turtle = new Turtle(world,-100, -100);

        var list = Stream.of(
                new Square(turtle, -100,0,"GREEN", 6, 100),
                new Triangle(turtle, 0,0,"BLACK", 6, 100),
                new Circle(turtle, 100,0,"MAGENTA", 6, 100)
        );
        list.forEach(Shape::draw);

//
//        Shape s1 = new XShape(turtle, -200,0,"GREEN", 6, 100, 100);
//        s1.draw();
    }
}
