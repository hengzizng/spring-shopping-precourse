package shopping;

import day2.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShoppingService {

    private final ShoppingRepository shoppingRepository;

    @Autowired
    private RestClient.Builder builder;
    private RestClient client;

    public ShoppingService(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    public List<CreateProductRequest> getProducts() {
        Map<Long, Product> productsMap = shoppingRepository.getProducts();

        List productList = productsMap.entrySet().stream().collect(Collectors.toList());

        return productList;
    }

    public void addProduct(CreateProductRequest createProductRequest) {
        if (isContainsProfanity(createProductRequest.name())) {
            return;
        }

        shoppingRepository.addProduct(
                new Product(
                        createProductRequest.id(),
                        createProductRequest.name(),
                        createProductRequest.price(),
                        createProductRequest.imageUrl()
                )
        );
    }

    public void updateProduct(CreateProductRequest createProductRequest) {
        Product product = shoppingRepository.getProductById(createProductRequest.id());
        product.setName(createProductRequest.name());
        product.setPrice(createProductRequest.price());
        product.setImageUrl(createProductRequest.imageUrl());
        shoppingRepository.updateProduct(product);
    }

    public CreateProductRequest getProductById(Long id) {
        Product product = shoppingRepository.getProductById(id);

        if (product == null) {
            return null;
        }

        return new CreateProductRequest(product.getId(), product.getName(), product.getPrice(), product.getImageUrl());
    }

    public void deleteProductById(long id) {
        shoppingRepository.deleteProductById(id);
    }

    private boolean isContainsProfanity(String text) {
        String url = "https://www.purgomalum.com/service/containsprofanity?text=" + text;

        var response = builder.build()
                .get()
                .uri(url + "/api/products")
                .retrieve();

//        var result = Boolean.valueOf(response.body(String.class));
        System.out.println("---------" + response.body(String.class));
//        System.out.println(result);

//        return result;
        return false;
    }
}
