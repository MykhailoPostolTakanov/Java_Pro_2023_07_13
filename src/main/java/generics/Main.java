package generics;

import java.awt.desktop.AppForegroundListener;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box();
        Box<Orange> box2 = new Box();
        Box<Apple> box3 = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        try {
            box1.add(apple1);
            box1.add(apple2);
            box2.add(orange1);
            box2.add(orange2);
            box3.add(apple2);
            box3.add(apple3);
            System.out.println(box1.getWeight());
            System.out.println(box2.getWeight());
            System.out.println(box1.compare(box2));
            box1.merge(box3);
        } catch (DifferentClassException differentClassException) {
            System.out.println(differentClassException.getMessage());
        }
    }
}
