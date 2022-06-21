package com.example.mappingtest.controller;

import com.example.mappingtest.form.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GetControllerTest {
    @GetMapping("names")
    public List<String> getNames() {
        return List.of("watanabe", "masao");
        //GET http://localhost:8080/names : Body [
        //                                        "watanabe",
        //                                        "masao"
        //                                       ]
    }

    @GetMapping("/names/{name}")
    public String getNames(@PathVariable String name) {
        return String.format("name %s", name);
        //GET http://localhost:8080/names/watanabe : Body name watanabe
    }

    @GetMapping("/get-name")
    public String getName(@RequestParam String name) {
        return String.format("name %s", name);
        //GET http://localhost:8080/get-name?name=watanabe : Body name watanabe
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
        // GET http://localhost:8080/greeting             Body : "id": 1, (counterにより表示回数に応じて増加)
        //    　　　　　　　　　　　　　　　　　　　                 　 "content": "Hello, world!"(defaultValueの値)
        // GET http://localhost:8080/greeting?name=User   Body : "id": 2, (counterにより表示回数に応じて増加)
        //                                                       "content": "Hello, User"(name=ここの値でcontentが変化)
    }
}
