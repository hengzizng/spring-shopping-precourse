package shopping;

import day2.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakeShoppingRepository implements ShoppingRepository {
    private final Map<Long, Product> products = new HashMap<>();

    @Override
    public Map<Long, Product> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        Product beforeProduct = getProductById(product.getId());
        beforeProduct.setName(product.getName());
        beforeProduct.setPrice(product.getPrice());
        beforeProduct.setImageUrl(product.getImageUrl());
    }

    @Override
    public Product getProductById(Long id) {
        return products.get(id);
    }

    @Override
    public void deleteProductById(Long id) {
        products.remove(id);
    }

}
