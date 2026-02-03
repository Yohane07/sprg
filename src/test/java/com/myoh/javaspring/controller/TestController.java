package com.myoh.javaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping("welcome")
    public String getWelcomeMessage() {
        return "Bienvenue chez nous, les controllers vont contacter les repos";
    }


}
