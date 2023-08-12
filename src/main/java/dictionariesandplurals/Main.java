package dictionariesandplurals;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Misha");
        coffeeOrderBoard.add("Yuri");
        coffeeOrderBoard.add("Oleg");
        coffeeOrderBoard.add("Olli");
        for (Order order : coffeeOrderBoard.draw()) {
            System.out.println(order.getOrderNumber() + "|" + order.getNameCustomer());
        }
        coffeeOrderBoard.deliver();
        for (Order order : coffeeOrderBoard.draw()) {
            System.out.println(order.getOrderNumber() + "|" + order.getNameCustomer());
        }
        coffeeOrderBoard.deliver(3);
        for (Order order : coffeeOrderBoard.draw()) {
            System.out.println(order.getOrderNumber() + "|" + order.getNameCustomer());
        }
        coffeeOrderBoard.add("Urgent");
        for (Order order : coffeeOrderBoard.draw()) {
            System.out.println(order.getOrderNumber() + "|" + order.getNameCustomer());
        }
    }
}
