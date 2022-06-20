package com.example.mappingtest.controller;

import com.example.mappingtest.form.DeleteForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeleteControllerTest {
    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id")int id, @Validated @RequestBody DeleteForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }
}
