package stream;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private final Category category;
    private double price;
    private final boolean discount;
    private final LocalDateTime created = LocalDateTime.now();

    public Product(Category category, double price, boolean discount) {
        this.category = category;
        this.price = price;
        this.discount = discount;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && discount == product.discount && category == product.category && Objects.equals(created, product.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, price, discount, created);
    }
}
