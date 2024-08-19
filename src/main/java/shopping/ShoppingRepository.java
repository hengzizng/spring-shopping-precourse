package shopping;

import java.util.List;
import java.util.Map;

public interface ShoppingRepository {
    Map<Long, Product> getProducts();
}
