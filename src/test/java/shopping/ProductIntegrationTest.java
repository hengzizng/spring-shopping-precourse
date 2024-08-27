package shopping;

import day2.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class ProductIntegrationTest {
    @Autowired
    private ProductService productService;

    @Test
    void 정상() {

    }

}