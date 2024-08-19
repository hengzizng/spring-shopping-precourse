package shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    private final ShoppingService shoppingService;

    public ProductRestController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return shoppingService.getProducts();
    }
}
