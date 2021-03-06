package com.simbirsoft.controllers;


import com.simbirsoft.dto.UserDto;
import com.simbirsoft.models.OrderT;
import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.security.details.UserDetailsImpl;
import com.simbirsoft.service.OrderService;
import com.simbirsoft.service.ProductService;
import com.simbirsoft.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;


@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private OrderService orderService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/main")
    public String home(@AuthenticationPrincipal UserDetailsImpl userSession, Model model) {
        model.addAttribute("username", userSession.getUsername());
        Optional<UsersT> userFromDB = usersService.findByUsername(userSession.getUsername());
        if (userFromDB.isPresent()) {
            UsersT usersT = userFromDB.get();
            if (usersT.getProductList().isEmpty())
                model.addAttribute("productsInCart", null);
            else
                model.addAttribute("productsInCart", usersT.getProductList());
            model.addAttribute("products", productService.getAllProducts());
        }
        return "main";
    }


    @PostMapping("cart/add")
    public String addToCart(
            @RequestParam("add") Product product,
            @org.springframework.security.web.bind.annotation.AuthenticationPrincipal UserDetailsImpl userSession
    ) {
        Optional<UsersT> user = usersService.findByUsername(userSession.getUsername());
        if (user.isPresent()) {
            UsersT usersT = user.get();
            usersT.getProductList().add(product);
            usersService.save(usersT);
        }
        return "redirect:/main";
    }




    @PostMapping("order")
    public String postOrder(
            @AuthenticationPrincipal UserDetailsImpl userSession,
            Model model
    ){
        UsersT user = userSession.getUser();

        OrderT order = new OrderT(user);
        order.getProductList().addAll(usersService.getUserProducts(user.getId()));
        order.setStatus(OrderT.Status.WAITING);
        order.setCabinet(user.getCabinet());
        order.setEmployeeID(user);

        user.setProductList(null);
        usersService.save(user);
        orderService.save(order);

        return "redirect:/main";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/account")
    public String getAccount(@AuthenticationPrincipal UserDetailsImpl userSession, Model model){
        model.addAttribute("user", userSession.getUser());

        if (userSession.getRole().equals("ADMIN")) {
            model.addAttribute("orders", orderService.getAllByStatus(OrderT.Status.WAITING));
        } else{
            model.addAttribute("role", "USER");
        if (orderService.getOrdersByUserId(userSession.getUser()).isEmpty())
            model.addAttribute("orders", null);
        else {
            model.addAttribute("orders", orderService.getOrdersByUserId(userSession.getUser()));
        }}
        return "account_page";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("order/in")
    public String orderIn(
            @RequestParam("order") Long orderId,
            @AuthenticationPrincipal UserDetailsImpl userSession,
            Model model
    ){
        if (userSession.getRole().equals("ADMIN"))
            model.addAttribute("role", "ADMIN");


        OrderT orderT = orderService.getOrdersByOrderID(orderId);
        model.addAttribute("orderInfo", orderService.getOrdersByOrderID(orderId));
        model.addAttribute("orders", orderT.getProductList());
        return "orderIn_page";
    }

    @PostMapping("order/decline")
    public String orderDecline(
        @RequestParam("orderId") Long orderId
    ){
        OrderT orderT = orderService.getOrdersByOrderID(orderId);
        orderT.setStatus(OrderT.Status.DECLINED);
        orderService.save(orderT);
        return "redirect:/account";
    }

    @PostMapping("order/delivered")
    public String orderDelivered(
            @RequestParam("orderId") Long orderId
    ){
        OrderT orderT = orderService.getOrdersByOrderID(orderId);
        orderT.setStatus(OrderT.Status.DELIVERED);
        orderService.save(orderT);
        return "redirect:/account";
    }
}

