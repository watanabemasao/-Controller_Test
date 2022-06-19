package com.example.mappingtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetControllerTest {
    @GetMapping("names")
    public List<String> getNames() {
        return List.of("watanabe", "masao");
    }

}
