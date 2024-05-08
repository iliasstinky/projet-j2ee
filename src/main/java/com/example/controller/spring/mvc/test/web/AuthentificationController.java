package com.example.controller.spring.mvc.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationController {

    @GetMapping("/")
    public String publicPage(){
        return "hellonigga";

    }
}
