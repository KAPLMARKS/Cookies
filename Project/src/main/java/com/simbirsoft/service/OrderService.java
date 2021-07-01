package com.simbirsoft.service;

import com.simbirsoft.models.OrderT;
import com.simbirsoft.models.UsersT;

public interface OrderService {
    void save(OrderT order);

    void setProductsToOrder(UsersT user, Long orderId);
}
