package Modul5;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double l, double w) {
        super("Rectangle");
        this.length = l;
        this.width = w;
    }

    @Override
    protected double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return super.toString() + " with length " + length + " and width " + width;
    }
}