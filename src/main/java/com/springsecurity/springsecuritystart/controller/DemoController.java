package com.springsecurity.springsecuritystart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String shoeHome(){
        return "home";
    }
}
