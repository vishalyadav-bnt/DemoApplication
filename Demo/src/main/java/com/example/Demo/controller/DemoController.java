package com.example.Demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    @GetMapping("/")
    public void show()
    {
        System.out.println("Helloo");
    }

}
