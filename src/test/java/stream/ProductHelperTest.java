package stream;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductHelperTest {

    @Test
    void filteredByCategoryAndPrice() {
        Product product1 = new Product(Category.BOOK, 120, false);
        Product product2 = new Product(Category.BOOK, 260, false);
        Product product3 = new Product(Category.COPYBOOK, 120, false);
        Product product4 = new Product(Category.BOOK, 1200, false);
        List<Product> products = List.of(product1, product2, product3, product4);
        products = ProductHelper.filteredByCategoryAndPrice(products, Category.BOOK, 250);
        List<Product> expected = List.of(product2, product4);
        assertEquals(expected, products);
    }

    @Test
    void filteredByCategoryAndSetDiscount() {
        Product product1 = new Product(Category.BOOK, 120, false);
        Product product2 = new Product(Category.BOOK, 260, true);
        Product product2Discount = new Product(Category.BOOK, 234, true);
        Product product3 = new Product(Category.COPYBOOK, 120, true);
        Product product4 = new Product(Category.BOOK, 1200, true);
        Product product4Discount = new Product(Category.BOOK, 1080, true);
        List<Product> products = List.of(product1, product2, product3, product4);
        products = ProductHelper.filteredByCategoryAndSetDiscount(products, Category.BOOK, 10);
        List<Product> expected = List.of(product2Discount, product4Discount);
        assertEquals(expected, products);
    }

    @Test
    void getTheCheapestProduct() {
        Product product1 = new Product(Category.BOOK, 12000, false);
        Product product2 = new Product(Category.BOOK, 260, false);
        Product product3 = new Product(Category.COPYBOOK, 120, false);
        Product product4 = new Product(Category.BOOK, 1200, false);
        List<Product> products = List.of(product1, product2, product3, product4);
        Product theCheapestBook = ProductHelper.getTheCheapestProduct(products, Category.BOOK);
        assertEquals(product2, theCheapestBook);
    }

    @Test
    void getProductsAfterSkip() {
        Product product1 = new Product(Category.BOOK, 120, false);
        Product product2 = new Product(Category.BOOK, 260, false);
        Product product3 = new Product(Category.COPYBOOK, 120, false);
        Product product4 = new Product(Category.BOOK, 1200, false);
        List<Product> products = List.of(product1, product2, product3, product4);
        List<Product> getLastAddedThreeProducts = ProductHelper.getProductsAfterSkip(products, 1);
        List<Product> expected = List.of(product2, product3, product4);
        assertEquals(expected, getLastAddedThreeProducts);
    }

    @Test
    void sumOfProductPricesForCurrentYear() {
        Product product1 = new Product(Category.BOOK, 12, false);
        Product product2 = new Product(Category.BOOK, 26, false);
        Product product3 = new Product(Category.COPYBOOK, 12, false);
        Product product4 = new Product(Category.BOOK, 120, false);
        List<Product> products = List.of(product1, product2, product3, product4);
        double totalPrice = ProductHelper.sumOfProductPricesForCurrentYear(products, Category.BOOK, 75);
        double expected = 38;
        assertEquals(expected, totalPrice);
    }

    @Test
    void groupByCategory() {
        Product product1 = new Product(Category.BOOK, 120, false);
        Product product2 = new Product(Category.BOOK, 260, false);
        Product product3 = new Product(Category.COPYBOOK, 120, false);
        Product product4 = new Product(Category.BOOK, 1200, false);
        List<Product> products = List.of(product1, product2, product3, product4);
        Map<Category, List<Product>> groupedProducts = ProductHelper.groupByCategory(products);
        Map<Category, List<Product>> expected = new HashMap<>();
        expected.put(Category.BOOK, List.of(product1, product2, product4));
        expected.put(Category.COPYBOOK, List.of(product3));
        assertEquals(expected, groupedProducts);
    }
}