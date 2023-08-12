package dictionariesandplurals;

import java.util.*;

public class CoffeeOrderBoard {
    Queue<Order> coffeeOrderBoard = new LinkedList<>();
    private int orderNumber = 1;

    public boolean add(String nameCustomer) {
        boolean resOdAdding = coffeeOrderBoard.offer(new Order(orderNumber, new String(nameCustomer)));
        orderNumber++;
        return resOdAdding;
    }

    public Order deliver() {
        return coffeeOrderBoard.remove();
    }

    public Order deliver(int orderNumberToDeleting) {
        Queue<Order> newCoffeeOrder = new LinkedList<>();
        Order deletedOrder = null;
        while (!coffeeOrderBoard.isEmpty()) {
            Order curOrder = coffeeOrderBoard.remove();
            if (curOrder.getOrderNumber() == orderNumberToDeleting) {
                deletedOrder = curOrder;
            } else {
                newCoffeeOrder.add(curOrder);
            }
        }
        coffeeOrderBoard = newCoffeeOrder;
        return deletedOrder;
    }

    public List<Order> draw() {
        List<Order> todraw = new LinkedList<>();
        for (Order curOrder : coffeeOrderBoard)
            todraw.add(curOrder);
        return todraw;
    }

    public Queue<Order> getCoffeeOrderBoard() {
        return coffeeOrderBoard;
    }
}
