package com.example.mappingtest.controller;

import com.example.mappingtest.form.CreateForm;
import com.example.mappingtest.form.PersonForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class PostControllerTest {

    @PostMapping("names")
    public ResponseEntity<String> create(@Validated @RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
        //POST http://localhost:8080/names/  Body : name successfully created
        // (KEY Location : VALUE : http://localhost:8080/names/id)
        // JSONのBodyの設定
        // {
        //   "name": "masao"
        // }
    }
    @PostMapping("/full-names")
    public String showNames(@RequestBody PersonForm personForm) {
      return String.format("Full name : %s %s", personForm.getFirstName(), personForm.getLastName());
      //http://localhost:8080/full-names  Body　Full name : watanabe masao
        // JSONのBodyの設定
        // {
        //   "firstName" :"watanabe",
        //   "lastName" :"masao"
        // }

    }
}
