package com.simbirsoft.controllers;


import com.simbirsoft.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {

    @Autowired
    private ProductSevice productSevice;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("products", productSevice.getAllProducts());

        return "main";
    }
}
