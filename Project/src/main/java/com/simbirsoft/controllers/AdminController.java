package com.simbirsoft.controllers;

import com.simbirsoft.dto.OrderDto;
import com.simbirsoft.models.OrderT;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.OrderRepository;
import com.simbirsoft.security.details.UserDetailsImpl;
import com.simbirsoft.service.OrderService;
import com.simbirsoft.service.OrderStaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private OrderStaffServiceImpl orderStaffServiceImpl;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/order/admin")
    public ModelAndView getConfirmationOrderPage(){
        List<OrderDto> orders = orderStaffServiceImpl.getAllOrders();
        ModelAndView modelAndView = new ModelAndView("orders");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }


}
