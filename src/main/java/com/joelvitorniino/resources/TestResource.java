package com.joelvitorniino.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestResource {
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("Hello, World!");
    }
}
