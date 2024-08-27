package day1;

import org.springframework.web.bind.annotation.*;

record TestRequest(String name) {
}

@RestController
public class TestProductRestController {
    @GetMapping("/api/test")
    public String test(
            @RequestParam(required = false, defaultValue = "World") String name
    ) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/api/test")
    public String test(@RequestBody TestRequest name) {
        return "Hello, " + name.name() + "!";
    }
}
