package com.example.market.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> hello()
    {
        return ResponseEntity.of(Optional.of("hello"));
    }
}