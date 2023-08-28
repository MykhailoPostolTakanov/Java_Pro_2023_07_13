package generics;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void getList() {
        Box<Apple> box = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        box.add(apple1);
        box.add(apple2);
        List<Apple> expected = new LinkedList();
        expected.add(apple1);
        expected.add(apple2);
        assertEquals(expected, box.getItems());
    }

    @Test
    void add() {
        Box<Apple> box = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        box.add(apple1);
        Apple result = box.add(apple2);
        assertEquals(apple2, result);
    }

    @Test
    void testAdd() {
        Box<Apple> box = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        List<Apple> apples = new LinkedList();
        apples.add(apple1);
        apples.add(apple2);
        List<Apple> result = box.add(apples);
        assertEquals(apples, result);
    }

    @Test
    void getWeight() {
        Box<Apple> box = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        box.add(apple1);
        box.add(apple2);
        box.add(apple3);
        assertEquals(3, box.getWeight());
    }

    @Test
    void compare() {
        Box<Apple> box1 = new Box();
        Box<Orange> box2 = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        box1.add(apple1);
        box1.add(apple2);
        box1.add(apple3);
        box2.add(orange1);
        box2.add(orange2);
        boolean result = box1.compare(box2);
        assertEquals(true, result);
    }

    @Test
    void merge() {
        Box<Apple> box1 = new Box();
        Box<Apple> box2 = new Box();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        box1.add(apple1);
        box1.add(apple2);
        box1.add(apple3);
        box2.add(apple2);
        box2.add(apple3);
        box1.merge(box2);
        List<Apple> expected = new LinkedList();
        expected.add(apple1);
        expected.add(apple2);
        expected.add(apple3);
        expected.add(apple2);
        expected.add(apple3);
        assertEquals(expected, box1.getItems());
    }
}