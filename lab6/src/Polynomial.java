import javax.print.attribute.standard.PagesPerMinute;
import javax.swing.text.PlainDocument;

public class Polynomial {
    private double a,b,c;

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }

    public Polynomial add(Polynomial p) {
        Polynomial poop = new Polynomial(this.a + p.getA(), this.b + p.getB(), this.c + p.getC());
        return poop;
    }

    public double evaluate(double x) {
        return ((this.a*x*x) + (this.b * x) + (this.c));
    }

}
