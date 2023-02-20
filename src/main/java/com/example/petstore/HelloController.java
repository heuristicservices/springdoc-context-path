package com.example.petstore;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import java.util.Map;

@RestController
@Tag(name = "hello", description = "hello")
public class HelloController {

    @GetMapping("/")
    @Operation(description = "index")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    @Operation(description = "hello world")
    public Map<String, String> hello() {
        return Map.of("fromCurrentContextPath", ServletUriComponentsBuilder.fromCurrentContextPath().toUriString(),
                "fromCurrentRequest", ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
                "fromCurrentServletMapping", ServletUriComponentsBuilder.fromCurrentServletMapping().toUriString());
    }
}
