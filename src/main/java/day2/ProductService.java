package day2;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository =  productRepository;
    }

    public void update(Long productId, String name) {
        final Product product = productRepository.findById(productId).get();

    }
}
