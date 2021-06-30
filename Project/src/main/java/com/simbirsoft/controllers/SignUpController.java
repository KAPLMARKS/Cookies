package com.simbirsoft.controllers;

import com.simbirsoft.dto.SignUpDto;
import com.simbirsoft.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpDto form) {
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}