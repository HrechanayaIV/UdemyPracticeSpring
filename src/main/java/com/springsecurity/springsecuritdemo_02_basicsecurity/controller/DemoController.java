package com.springsecurity.springsecuritdemo_02_basicsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String shoeHome(){
        return "home";
    }
}
