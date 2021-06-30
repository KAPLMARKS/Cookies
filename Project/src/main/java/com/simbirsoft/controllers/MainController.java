package com.simbirsoft.controllers;


import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.security.details.UserDetailsImpl;
import com.simbirsoft.service.ProductService;
import com.simbirsoft.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/main")
    public String home(@AuthenticationPrincipal UserDetailsImpl userSession, Model model){
        UsersT userFromDB = usersService.findByUsername(userSession.getUsername());
        model.addAttribute("productsInCart", userFromDB.getProductList());
        model.addAttribute("products", productService.getAllProducts());
        return "main";
    }


    @PostMapping("cart/add")
    public String addToCart(
            @RequestParam("add") Product product,
            @org.springframework.security.web.bind.annotation.AuthenticationPrincipal UserDetailsImpl userSession
    ) {
        UsersT user = usersService.findByUsername(userSession.getUsername());
        user.getProductList().add(product);
        usersService.save(user);

        return "redirect:/main";
    }
}
