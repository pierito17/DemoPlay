package com.demo.play.web.controller;

import com.demo.play.dominio.service.DemoPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String platform;
    private final DemoPlayAiService demoPlayAiService;

    public HelloController(@Value("${spring.application.name}") String platform, DemoPlayAiService demoPlayAiService) {
        this.platform = platform;
        this.demoPlayAiService = demoPlayAiService;

    }

    @GetMapping("/hello")
    public String hello() {
        return this.demoPlayAiService.generateGreeting(platform);
    }
}
