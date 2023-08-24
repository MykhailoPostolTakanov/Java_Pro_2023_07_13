package generics;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        try {
            /*box.add(apple1);
            box.add(apple2);
            box.add(orange1);*/
            /*List list = new LinkedList();
            list.add(apple1);
            list.add(apple2);
            box.add(list);
            List list2 = new LinkedList();
            list2.add(orange1);
            box.add(list2);*/
            box1.add(apple1);
            box1.add(apple2);
            //box1.add(apple3);
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
