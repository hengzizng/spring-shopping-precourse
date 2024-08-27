package shopping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTest {
    @Autowired
    private ApplicationContext context;

    @Test
    void test1() {
        System.out.println("application test1: " + context);
    }

    @DirtiesContext
    @Test
    void test2() {
        System.out.println("application test2: " + context);
    }

}