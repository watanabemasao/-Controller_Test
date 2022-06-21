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
    @DeleteMapping ("Users")
    public ResponseEntity<String> delete(@Validated @RequestBody DeleteForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/Users/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("message2 User successfully deleted");
        //POST http://localhost:8080/User/  Body : message2 User successfully deleted
        // (KEY Location : VALUE : http://localhost:8080/Users/id)
        // JSONのBodyの設定
        // {
        //   "name": "watanabe"
        // }
    }
}
