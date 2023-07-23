package Polymorphism;

public class Triangle implements Shape {
    private int firstSide;
    private int secondSide;
    private int angleBetweenThem;

    public Triangle(int firstSide, int secondSide, int angleBetweenThem) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.angleBetweenThem = angleBetweenThem;
    }

    public int getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(int firstSide) {
        this.firstSide = firstSide;
    }

    public int getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(int secondSide) {
        this.secondSide = secondSide;
    }

    public int getAngleBetweenThem() {
        return angleBetweenThem;
    }

    public void setAngleBetweenThem(int angleBetweenThem) {
        this.angleBetweenThem = angleBetweenThem;
    }

    @Override
    public double getArea() {
        double radian = Math.toRadians(angleBetweenThem);
        return 0.5 * firstSide * secondSide * Math.sin(radian);
    }
}
