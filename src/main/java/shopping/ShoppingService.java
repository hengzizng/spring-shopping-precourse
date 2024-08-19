package shopping;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShoppingService {

    private final ShoppingRepository shoppingRepository;

    public ShoppingService(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    public List<Product> getProducts() {
        Map<Long, Product> productsMap = shoppingRepository.getProducts();
        List productList = productsMap.entrySet().stream().collect(Collectors.toList());

        return productList;
    }

}
