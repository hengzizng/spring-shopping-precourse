package day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestProductRestControllerTest {
    @Autowired
    private RestTemplateBuilder builder;
    private RestTemplate client;
    // RestClient, HttpClient? 사용해서도 해보기

//    @Autowired
//    private RestClient restClient;
//    private RestClientBuilderConfigurer restBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        client = builder.build();
//        restClient = restBuilder.build();
    }

    @Test
    void test1() {
        var url = "http://localhost:" + port + "/api/test";
        var actual = client.getForObject(url, String.class);
        assertThat(actual).isEqualTo("Hello, World!");
    }

    @Test
    void test2() {
        var url = "http://localhost:" + port + "/api/test?name=Jason";
        var actual = client.getForObject(url, String.class);
        assertThat(actual).isEqualTo("Hello, Jason!");
    }

    @Test
    void test3() {
        var url = "http://localhost:" + port + "/api/test";
        // json 으로 사용하면 DTO 사용하지 않아도 되지만, header에 data type 설정 해줘야함
        // var json = "{\"name\":\"Jason\"}";
        var request = new RequestEntity<TestRequest>(
                new TestRequest("Jason"),
                HttpMethod.POST,
                URI.create(url)
        );
        var actual = client.exchange(request, String.class).getBody();
        assertThat(actual).isEqualTo("Hello, Jason!");
    }
}