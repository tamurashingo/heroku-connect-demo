package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        return "user";
    }
}
