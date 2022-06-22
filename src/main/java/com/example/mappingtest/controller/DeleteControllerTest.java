package com.example.mappingtest.controller;

import com.example.mappingtest.form.DeleteForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class DeleteControllerTest {
    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id")int id, @Validated @RequestBody DeleteForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
        // DELETE http://localhost:8080/names/1  body : "message": "name successfully deleted"
        // {
        //   "name": "watanabe"
        // }
    }
}
