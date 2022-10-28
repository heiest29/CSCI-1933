import java.lang.Math;

public class Test {
    double width, height;

    public Test(double height, double width) {
        this.width = width;
        this.height = height;
    }
    public double getPerim() {
        double c = Math.sqrt((Math.pow(width/2,2))+(Math.pow(height,2)));
        return c + c + width;
    }



    public static void main(String[] args) {
        Test newtest = new Test(340,400);
        System.out.println(newtest.getPerim());
    }
}
