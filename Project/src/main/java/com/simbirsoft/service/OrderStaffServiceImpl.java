package com.simbirsoft.service;

import com.simbirsoft.dto.OrderDto;
import com.simbirsoft.models.OrderT;
import com.simbirsoft.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderStaffServiceImpl implements OrderStaffService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderT> orders = orderRepository.findAll();
        return OrderDto.from(orders);
    }

    @Override
    public boolean declinedOrder(OrderDto orderDto) {
        OrderT orderT = OrderT.castToModel(orderDto);
        Optional<OrderT> optionalOrderT = orderRepository.findById(orderDto.getOrderID());
        //добавить условия когда деливеред когда деклайнед
        if (optionalOrderT.isPresent()) {
            if (optionalOrderT.get().getStatus().equals(OrderT.Status.WAITING)) {
                orderRepository.setOrderDeclinedStatus(orderT.getOrderID());
                orderDto.setStatus(OrderT.Status.DECLINED);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deliveredOrder(OrderDto orderDto) {
        OrderT orderT = OrderT.castToModel(orderDto);
        Optional<OrderT> optionalOrderT = orderRepository.findById(orderDto.getOrderID());
        //добавить условия когда деливеред когда деклайнед
        if (optionalOrderT.isPresent()) {
            if (optionalOrderT.get().getStatus().equals(OrderT.Status.WAITING)) {
                orderRepository.setOrderDeliveredStatus(orderT.getOrderID());
                orderDto.setStatus(OrderT.Status.DELIVERED);
                return true;
            }
        }
        return false;
    }
}

