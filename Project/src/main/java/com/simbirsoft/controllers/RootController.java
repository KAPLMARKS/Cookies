package com.simbirsoft.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;

@Configuration
@RequestMapping("/")
public class RootController {

    @PermitAll
    @GetMapping
    public String getRoot(Authentication authentication){
        if (authentication != null){
            return "redirect:/main";
        } else {
            return "redirect:/signIn";
        }
    }
}
