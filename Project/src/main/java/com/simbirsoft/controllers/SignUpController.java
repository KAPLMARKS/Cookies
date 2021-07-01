package com.simbirsoft.controllers;

import com.simbirsoft.dto.SignUpDto;
import com.simbirsoft.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Objects;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PermitAll
    @GetMapping("/signUp")
    public String getPage(Model model) {
        model.addAttribute("signUpDto", new SignUpDto());
        return "signUp";
    }

    @PermitAll
    @PostMapping("/signUp")
    public String signUp(@Valid SignUpDto form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("signUpDto", form);
            return "signUp";
        }

        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}