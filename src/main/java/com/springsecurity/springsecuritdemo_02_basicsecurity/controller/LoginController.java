package com.springsecurity.springsecuritdemo_02_basicsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
       // return "plain-login";
        //for bootstrap login
        return "fancy-login";
    }
}
