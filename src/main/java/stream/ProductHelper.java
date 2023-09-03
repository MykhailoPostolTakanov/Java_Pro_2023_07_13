package stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductHelper {
    public static List<Product> filteredByCategoryAndPrice(List<Product> list, Category category, double price) {
        return list.stream()
                .filter(product -> product.getCategory().equals(category))
                .filter(product -> product.getPrice() > price)
                .toList();
    }

    public static List<Product> filteredByCategoryAndSetDiscount(List<Product> list, Category category, int discount) {
        return list.stream()
                .filter(product -> product.getCategory().equals(category))
                .filter(Product::getDiscount)
                .peek(product -> product.setPrice((product.getPrice() * (100 - discount)) / 100))
                .toList();
    }

    public static Product getTheCheapestProduct(List<Product> list, Category category) {
        return list.stream()
                .filter(product -> product.getCategory().equals(category))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("The product list is empty!"));
    }

    public static List<Product> getProductsAfterSkip(List<Product> list, int howMuchSkip) {
        return list.stream()
                .skip(howMuchSkip)
                .toList();
    }

    public static double sumOfProductPricesForCurrentYear(List<Product> list, Category category, double maxPrice) {
        return list.stream()
                .filter(product -> product.getCreated().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getCategory().equals(category))
                .filter(product -> product.getPrice() <= maxPrice)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<Category, List<Product>> groupByCategory(List<Product> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }
}
