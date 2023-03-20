package com.surja.Coco.Math.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/math")
public class MathController {
    @GetMapping("/")
    public ResponseEntity<String> function() {
        return new ResponseEntity<>("Welcome to neumerical analysis", HttpStatus.OK);
    }

}
