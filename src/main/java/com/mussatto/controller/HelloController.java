package com.mussatto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "HelloController " + name;
    }

    @RequestMapping("/secured")
    public String secured(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Secured this is - " + name;
    }
}
