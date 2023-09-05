package stream;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private final Category category;
    private double price;
    private final boolean discount;
    private LocalDateTime created = LocalDateTime.now();

    public Product(Category category, double price, boolean discount) {
        this.category = category;
        this.price = price;
        this.discount = discount;
    }

    public Product(Category category, double price, boolean discount, LocalDateTime created) {
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        double epsilon = 0.000001d;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Math.abs(product.price - price) < epsilon && discount == product.discount && category == product.category && Objects.equals(created, product.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, price, discount, created);
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", price=" + price +
                ", discount=" + discount +
                ", created=" + created +
                '}';
    }
}
