package com.springboot.securityprac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloSecurity() {
        return "Hello Security!!" ;
    }
}
