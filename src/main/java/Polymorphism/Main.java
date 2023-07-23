package Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        Shape triangle = new Triangle(10, 5, 30);
        Shape square = new Square(10);
        Shape[] arrShape = {circle, triangle, square};
        System.out.println(circle.getArea());
        System.out.println(triangle.getArea());
        System.out.println(square.getArea());
        System.out.println(getSumAreasOfShapes(arrShape));
        Member[] arrMembers = {new Human(500, 3), new Cat(200, 7), new Robot(2000, 35)};
        Obstacle[] arrObstacles = {new Racetrack(300), new Wall(5)};
        passingObstacles(arrMembers, arrObstacles);
    }

    public static double getSumAreasOfShapes(Shape[] arr) {
        double sumAreas = 0;
        for (Shape shape : arr) {
            sumAreas += shape.getArea();
        }
        return sumAreas;
    }

    public static void passingObstacles(Member[] arrMembers, Obstacle[] arrObstacles) {
        for (Member member : arrMembers)
            for (Obstacle obstacle : arrObstacles)
                if (!obstacle.overcome(member))
                    break;
    }
}
