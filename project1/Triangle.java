// Written by Cameron Estes - estes091

import java.awt.Color;   // need to import the color class in order to get and set colors for a specific triangle object
import java.lang.Math;  // this is needed to find the hypotensue of the sides of the triangle.  We need the sqrt() function of the Math class

public class Triangle {
    double xleft;
    double yleft;
    double width;
    double height;
    Color currentColor;

    // ran into trouble because I forgot to put the attributes in the correc order when creating a triangle object
    // also added the "Color c" attribute to make it easier to set the color when making a new object
    public Triangle(double x, double y, double wid, double hei, Color c) { // the constructor takes in all relevant attributes of the class and initializes them for this specfic instance of triangle
        xleft = x;
        yleft = y;
        width = wid;
        height = hei;
        currentColor = c;
    }

    public double calculatePerimeter() {  // to find the permimeter of an isosceles triangle one must caluclate the hypotenuse of half the base and the height to get the long leg
        double c = Math.sqrt((Math.pow(width/2,2))+(Math.pow(height,2)));
        return c + c + width;
    }
    public double calculateArea() { // area of isosceles is simple as (base*height)/2
        return ((width*height)/2);
    }

    public void setColor(Color c) {
        this.currentColor = c;
    }
    public Color getColor() {
        return currentColor;
    }

    public void setPos(double newx, double newy) {
        this.xleft = newx;
        this.yleft = newy;
    }                                      // the getters and setters are grouped based on the attributes they change and receive as input
    public double getXPos() {
        return xleft;
    }
    public double getYPos() {
        return yleft;
    }

    public void setHeight(double h) {
        this.height = h;
    }
    public void setWidth(double w) {
        this.width = w;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
}