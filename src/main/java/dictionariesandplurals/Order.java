package dictionariesandplurals;

import java.util.Objects;

public class Order {
    private int orderNumber;
    private String nameCustomer;

    public Order(int orderNumber, String nameCustomer) {
        this.orderNumber = orderNumber;
        this.nameCustomer = nameCustomer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(nameCustomer, order.nameCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, nameCustomer);
    }
}
