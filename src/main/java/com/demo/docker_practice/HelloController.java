package com.demo.docker_practice;

import com.demo.docker_practice.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        return Map.of(
                "message", greetingService.greet("Docker"),
                "timestamp", LocalDateTime.now().toString()
        );
    }
    @GetMapping("/bye")
    public Map<String, Object> bye() {
        return Map.of(
                "message", "Bye from Docker!",
                "timestamp", LocalDateTime.now().toString()
        );
    }
}