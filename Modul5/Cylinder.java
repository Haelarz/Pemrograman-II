package Modul5;

public class Cylinder extends Shape{
    private double radius;
    private double height;

    public Cylinder(double r, double h) {
        super("Cylinder");
        this.radius = r;
        this.height = h;
    }

    @Override
    protected double area() {
        return 2 * Math.PI * radius * (height + radius);
    }

    @Override
    public String toString() {
        return super.toString() + " with radius " + radius + " and height " + height;
    }
}