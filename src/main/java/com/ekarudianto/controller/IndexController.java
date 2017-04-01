package com.ekarudianto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String getIndex() {
        return "Welcome to spring boot!";
    }
}