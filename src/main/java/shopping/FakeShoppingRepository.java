package shopping;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakeShoppingRepository implements ShoppingRepository {
    private final Map<Long, Product> products = new HashMap<>();

    @Override
    public Map<Long, Product> getProducts() {
        return products;
    }

}
