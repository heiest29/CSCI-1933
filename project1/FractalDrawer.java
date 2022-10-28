// Written by Cameron Estes - estes091

import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area
    public Color[] colors = {Color.RED,Color.BLUE,Color.BLACK,Color.GREEN,Color.GRAY,Color.MAGENTA,Color.DARK_GRAY};

    public FractalDrawer() {}  // contructor


    // All this method is responsible for is making calls to the drawfractal methods depending on the user input.
    // Additionally, it simply returns the global variable known as totalArea once the call to fractal has been made
    public double drawFractal(String type) {
        Canvas c1 = new Canvas(1600,1600);
        if (type.equals("Rectangle")) {
            drawRectangleFractal(250,125,600,500,Color.BLUE,c1,0);
        }
        else if (type.equals("Triangle")) {
            drawTriangleFractal(400,340.0,600,450,Color.RED,c1,0);
        }
        else if (type.equals("Circle")) {
            drawCircleFractal(100,750,500,Color.GREEN,c1,0);
        }
        return totalArea;
    }

    // Triangle fractal is made using the simple base case of if level == 8 to determine when the fractal should stop calling.
    // otherwise, it makes three new recursive calls to drawTriangleFractal, with different values associating to the x and y position.
    // The goal here was to make new triangles appear right on the midpoint of each side
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Random random = new Random();
        int newind = random.nextInt(colors.length);

        Triangle newTri1 = new Triangle(x, y, width, height, colors[newind]);
        can.drawShape(newTri1);
        totalArea += newTri1.calculateArea();

        if (level==8) {
            return;
        }
        else if (level <= 8) {
            drawTriangleFractal(width*.5, height*.5, (x+(.25*width))-(width*.5), y-(.5*height), colors[newind],can, level+1);
            drawTriangleFractal(width/2, height/2, (x+(.75*width)), (y-(.5*height)), colors[newind], can, level+1);
            drawTriangleFractal(width/2, height/2, (x+(.25*width)), (y+(.5*height)), colors[newind], can, level+1);
        }
    }


    // just like trianglefractal, drawCircleFractal utilizes the same base case and recursive calls, except there are 4 recursive calls made each time
    // since the project requirements state that there must be 4 shapes per layer for rectangle and circle
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Random random = new Random();
        int newind = random.nextInt(colors.length);

        Circle newCirc1 = new Circle(x,y,radius,colors[newind]);
        can.drawShape(newCirc1);
        totalArea += newCirc1.calculateArea();

        if (level==8) {
            return;
        }
        else if (level <= 8) {
            drawCircleFractal(radius*.5, (x+(2*radius)), y , colors[newind],can, level+1);
            drawCircleFractal(radius*.5, (x-(2*radius)), y , colors[newind], can, level+1);
            drawCircleFractal(radius*.5, x, (y+(2*radius)), colors[newind], can, level+1);
            drawCircleFractal(radius*.5, x, (y-(2*radius)), colors[newind], can, level+1);
        }
    }


    // similar to circle, there are 4 shapes generated per later as per the requirements for full crefit.
    // as desribed before, the recursive solution for each fractal is relatively the same, except here I had to increment the x position by some fraction of the width,
    // and the y position by soms fraction of the height
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Random random = new Random();
        int newind = random.nextInt(colors.length);

        Rectangle newRect1 = new Rectangle(x, y, width, height, colors[newind]);
        can.drawShape(newRect1);
        totalArea += newRect1.calculateArea();

        if (level==8) {
            return;
        }
        else if (level <= 8) {
            drawRectangleFractal(width/2, height/2, (x+(.25*width)), (y+(1.5*height)), colors[newind],can, level+1);
            drawRectangleFractal(width/2, height/2, (x+(.25*width)), (y-(1.5*height))+height/2, colors[newind],can, level+1);
            drawRectangleFractal(width/2, height/2, (x+(1.5*width)), (y+(.25*width)), colors[newind],can, level+1);
            drawRectangleFractal(width/2, height/2, (x-(1.5*width))+width/2, (y+(.25*width)), colors[newind],can, level+1);
        }
    }

    // the main method simply instantiates a scanner object and a fractal drawer object, and asks the user for input and makes a call to drawFractal
    // depending on the input the user puts in
    // after each call the scanner is closed as well to avoid errors
    public static void main(String[] args){
        FractalDrawer draw = new FractalDrawer();
        Scanner s1 = new Scanner(System.in);
        System.out.println("What shape would you like to draw a fractal of?  Rectangle, Circle, or Triangle???");
        String line = s1.next();

        if (line.equals("Rectangle") || line.equals("rectangle")) {
            double area = draw.drawFractal("Rectangle");
            System.out.println("The total area of this fractal is: " + area);
            s1.close();
        }
        if (line.equals("Circle") || line.equals("circle")) {
            double area = draw.drawFractal("Circle");
            System.out.println("The total area of the fractal is: " + area);
            s1.close();
        }
        else if (line.equals("Triangle") || line.equals("triangle")) {
            double area = draw.drawFractal("Triangle");
            System.out.println("The total are of this fractal is: " + area);
            s1.close();
        }
    }
}
