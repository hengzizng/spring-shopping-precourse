package shopping;

import day2.Product;

import java.util.Map;

public interface ShoppingRepository {
    Map<Long, Product> getProducts();

    void addProduct(Product createProductRequest);

    void updateProduct(Product createProductRequest);

    Product getProductById(Long id);

    void deleteProductById(Long id);
}
