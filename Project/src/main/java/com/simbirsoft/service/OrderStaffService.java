package com.simbirsoft.service;

import com.simbirsoft.dto.OrderDto;

import java.util.List;

public interface OrderStaffService {

    List<OrderDto> getAllOrders();

    boolean declinedOrder(OrderDto orderDto);

    boolean deliveredOrder(OrderDto orderDto);
}
