package com.example.market.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AuthController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/signin")
    public String signin(){
        return "signin.html";
    }

    @PostMapping("/lol")
    @ResponseBody
    public String lolResponse()
    {
        return "lol-response";
    }

    @GetMapping("/get-lol")
    @ResponseBody
    public String getLolResponse()
    {
        return "get-lol-response";
    }
}