package dictionariesandplurals;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {

    @Test
    void add() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        boolean res = coffeeOrderBoard.add("Misha");
        assertEquals(true, res);
    }

    @Test
    void deliver() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Misha");
        coffeeOrderBoard.add("Yuri");
        coffeeOrderBoard.add("Oleg");
        coffeeOrderBoard.add("Olli");
        Order res = coffeeOrderBoard.deliver();
        Order expected = new Order(1, "Misha");
        assertEquals(expected, res);
    }

    @Test
    void testDeliverByOrderNumber() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Misha");
        coffeeOrderBoard.add("Yuri");
        coffeeOrderBoard.add("Oleg");
        coffeeOrderBoard.add("Olli");
        Order res = coffeeOrderBoard.deliver(3);
        Order expected = new Order(3, "Oleg");
        assertEquals(expected, res);
    }

    @Test
    void draw() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Misha");
        coffeeOrderBoard.add("Yuri");
        coffeeOrderBoard.add("Oleg");
        coffeeOrderBoard.add("Olli");
        List<Order> res = coffeeOrderBoard.draw();
        List<Order> expected = new LinkedList<Order>();
        expected.add(new Order(1, "Misha"));
        expected.add(new Order(2, "Yuri"));
        expected.add(new Order(3, "Oleg"));
        expected.add(new Order(4, "Olli"));
        assertEquals(expected, res);
    }

    @Test
    void getCoffeeOrderBoard() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Misha");
        coffeeOrderBoard.add("Yuri");
        coffeeOrderBoard.add("Oleg");
        coffeeOrderBoard.add("Olli");
        Queue<Order> expected = new LinkedList<Order>();
        expected.add(new Order(1, "Misha"));
        expected.add(new Order(2, "Yuri"));
        expected.add(new Order(3, "Oleg"));
        expected.add(new Order(4, "Olli"));
        assertEquals(expected, coffeeOrderBoard.getCoffeeOrderBoard());
    }
}