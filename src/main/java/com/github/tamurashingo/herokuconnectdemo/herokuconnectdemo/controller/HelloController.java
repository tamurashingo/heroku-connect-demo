package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("hello world");
        model.addAttribute("message", "hello world");
        return "hello_view";
    }
}
