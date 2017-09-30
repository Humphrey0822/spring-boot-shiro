package com.ouyeel.xplat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/custom/login")
    public String login(){
        return "custom/login";
    }
}
