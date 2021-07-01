package com.simbirsoft.service;

import com.simbirsoft.models.OrderT;
import com.simbirsoft.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(OrderT order) {
        orderRepository.save(order);
    }
}
