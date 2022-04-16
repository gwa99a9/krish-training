package com.gsd.rentarar.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String greeting() {
        return "Hello World : GET";
    }
    @RequestMapping(value = "/greeting",method = RequestMethod.POST)
    public String greetingPost() {
        return "Hello World : POST";
    }
}
