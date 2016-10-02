package com.mussatto.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "HelloController " + name;
    }

    @RequestMapping("/secured")
    public String secured() {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Map<String, String> details = (Map<String, String>) userAuthentication.getDetails();
        System.out.println(details);
        return "Hello, " + details.get("name");
    }
}
