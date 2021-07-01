package com.simbirsoft.service;

import com.simbirsoft.models.OrderProductsT;
import com.simbirsoft.models.OrderT;

import java.util.List;

public interface OrderProductsService {
    List<OrderProductsT>  orderProductsByOrderIdAndProductId(Long productId, OrderT orderID, int count) throws Exception;
    void updateCountByOrderId(Long orderID, int count) throws Exception;
}
