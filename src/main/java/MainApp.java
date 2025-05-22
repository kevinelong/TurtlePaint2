import java.awt.*;

public class MainApp
{
    public static void main(String[] args)
    {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
        World world = new World(400, 400);
        Turtle turtle = new Turtle(world,-100, -100);

        Shape s1 = new XShape(turtle, 0,0,"GREEN", 6, 200, 200);
        s1.draw();
    }
}
