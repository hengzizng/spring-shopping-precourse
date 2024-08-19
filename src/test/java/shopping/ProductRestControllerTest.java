package shopping;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.awt.*;
import java.net.http.HttpHeaders;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductRestControllerTest {

    @Autowired
    private RestClient.Builder restBuilder;

    private RestClient restClient;


    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restClient = restBuilder.defaultHeader(org.springframework.http.HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @Test
    void getProductsTest() {
        var url = "http://localhost:" + port + "/api/products";

        List testProducts = restClient.get().uri(url)
                .retrieve().body(List.class);

        Assertions.assertThat(testProducts).isEmpty();

    }
}