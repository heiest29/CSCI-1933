// Written by Cameron Estes - estes091

import java.awt.Color;   // need to import the color class in order to get and set colors for a specific triangle object

public class Rectangle {
    public double xpos, ypos,width, height;  // relevant attributes are the position variables, the length and height, and the color
    public Color currentColor;


    // ran into trouble with this constructor because I mistakingly added the attributes in a different order in "fractaldrawer" than described in the class
    // decided to add "Color c" to the constructor to make is easier to set the color for each object that is drawn
    public Rectangle(double x, double y, double w, double h, Color c) {
        this.xpos = x;
        this.ypos = y;
        this.width = w;
        this.height = h;
        this.currentColor = c;
    }

    public double calculatePerimeter() { // the area and perimeter methods are simple enough as they just multiple or sum up the sides
        return (2*this.width) + (2*this.height);
    }
    public double calculateArea() {
        return (this.width*this.height);
    }

    public void setColor(Color c) {
        this.currentColor = c;
    }
    public Color getColor() {
        return this.currentColor;
    }

    public void setPos(double x, double y) {  // the getters and setters are all grouped according to the attributes they change output
        this.xpos = x;
        this.ypos = y;
    }
    public double getXPos() {
        return this.xpos;
    }
    public double getYPos() {
        return this.ypos;
    }

    public void setHeight(double h) {
        this.height = h;
    }
    public void setWidth(double w) {
        this.width = w;
    }
    public double getHeight() {
        return this.height;
    }
    public double getWidth() {
        return this.width;
    }
}
