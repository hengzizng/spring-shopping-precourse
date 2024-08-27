package day2;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@Transactional
@SpringBootTest
class ProductServiceTest {
    private ProductService productService;
    private ProductRepository productRepository = mock(ProductRepository.class);

    public ProductServiceTest() {
        productService = new ProductService(productRepository);
    }

    @Test
    void update() {
        // given
        // when = given
        var productId = 1L;
        var product = new Product();
        // productService.update 에서 findById도 실행하기 때문에 findById에 대한 return값도 설정 필요
        given(productRepository.findById(any())).willReturn(Optional.of(product));

        // when
        productService.update(1L, "카페라떼");

        // then
        // verify = then
        // save가 실행되었는지 확인
        //then(productRepository.should(times(1)).save(any());

    }

}