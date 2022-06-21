package com.example.mappingtest.controller;

import com.example.mappingtest.form.UpdateForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PatchControllerTest {
    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id")int id, @Validated @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
        // PATCH http://localhost:8080/names/1  Body : "message": "name successfully deleted"
        // JSONのBodyの設定
        // {
        //  "name" :"watanabe",
        // }
    }
}
