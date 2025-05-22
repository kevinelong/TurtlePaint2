package com.example.shapes;

import com.example.logo.Turtle;

import java.awt.*;

public abstract class Shape implements IDrawable {
    //    turtle: the turtle that is used to paint the shape
    protected Turtle turtle;

    //    location: Point -- the x,y coordinate where the shape
    //    should be drawn
    protected int xPosition;
    protected int yPosition;

    //    color: the color used for the border
    protected String colorName;

    //    border: the width of the shape border
    protected int borderWidth;

    //    paint() - the method that paints the shape could be render() we will use draw()
    public void draw() {
        // child classes will override this
        setColor();
        turtle.penUp();
        turtle.goTo(xPosition, yPosition);
        turtle.setHeading(0);
        turtle.setPenWidth(borderWidth);
        turtle.penDown();
    }
    public Shape(Turtle turtle, int xPosition, int yPosition, String colorName, int borderWidth){
        //Note no height, width, or radius as not all shapes have these.
        this.turtle = turtle;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.colorName = colorName;
        this.borderWidth = borderWidth;
    }
    protected void setColor(){
        if(colorName.equalsIgnoreCase("GREEN")) {
            turtle.setColor(Color.GREEN);
        }else if(colorName.equalsIgnoreCase("BLUE")) {
            turtle.setColor(Color.BLUE);
        }else if(colorName.equalsIgnoreCase("MAGENTA")) {
            turtle.setColor(Color.MAGENTA);
        }else if(colorName.equalsIgnoreCase("BLACK")) {
            turtle.setColor(Color.BLACK);
        }else if(colorName.equalsIgnoreCase("RED")) {
            turtle.setColor(Color.RED);
        }else{
            turtle.setColor(Color.BLACK);
        }

    }
}
