// Written by Cameron Estes - estes091

import static java.lang.Math.PI; // did some google searching for a way to easily represent PI in java and found this on linuxhint.com
import java.awt.Color; // in order to represet colors as their own objects you have to import the color class which is an extension of the object class


public class Circle {
    public double xPos, yPos, radius;
    public Color currentColor;
    public double pie = 3.141592653589;

    // added the "Color c" attribute to make it easier to set the color
    // had trouble making circle objects because the order of the attributes in the constructor didnt match the numbers I specfied in the instantiation of the objects
    public Circle(double xPosition, double yPosition, double rad, Color c) {
        this.xPos = xPosition;
        this.yPos = yPosition;
        this.radius = rad;
        this.currentColor = c;
    }

    public double calculatePerimeter() {
        return (2*pie*radius);
    }                                         // grouped the methods of the class together based on the attributes they either use or alter
    public double calculateArea() {
        return (pie*(radius*radius));
    }

    public void setRadius(double r) {
        this.radius = r;
    }
    public double getRadius() {
        return this.radius;
    }

    public void setColor(Color newColor) {
        this.currentColor = newColor;
    }                                        // to make a method that has return type Color, I had to import the color class in line 3 above
    public Color getColor() {
        return this.currentColor;
    }

    public void setPos(double x, double y) {
        this.xPos = x;
        this.yPos = y;
    }
    public double getXPos() {
        return this.xPos;
    }
    public double getYPos() {
        return this.yPos;
    }
}
