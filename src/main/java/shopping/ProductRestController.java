package shopping;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

record ProductResponse(Long id, String name, int price, String imageUrl) {
}

record CreateProductRequest(
        Long id,
        @Pattern(regexp = "^[a-zA-Z0-9가-힣\\[\\]\\/\\)_+\\-&\\(]{0,15}", message = "특수문자는 ( ), [ ], +, -, &, /, _ 만 사용 가능합니다.") String name,
        int price,
        String imageUrl
) {
    CreateProductRequest(String name, int price, String imageUrl) {
        this(null, name, price, imageUrl);
    }
}

@RestController
public class ProductRestController {
    private final ShoppingService shoppingService;

    public ProductRestController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<CreateProductRequest>> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(shoppingService.getProducts());
    }

    @PostMapping("/api/products")
    public ResponseEntity<Void> addProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        shoppingService.addProduct(createProductRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/api/products")
    public ResponseEntity<Void> updateProduct(@RequestBody CreateProductRequest createProductRequest) {
        shoppingService.updateProduct(createProductRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/api/products")
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
        shoppingService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
