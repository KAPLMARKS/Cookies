package com.simbirsoft.service;

import com.simbirsoft.models.OrderProductsT;
import com.simbirsoft.models.OrderT;
import com.simbirsoft.models.Product;
import com.simbirsoft.repositories.OrderProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderProductsServiceImpl implements OrderProductsService {

    @Autowired
    OrderProductsRepository orderProductsRepository;

    @Autowired
    ProductServiceImpl productServiceImpl;

    @Override
    public List<OrderProductsT> orderProductsByOrderIdAndProductId(Long productId, OrderT orderId, int count) throws Exception {
        try {
            if(orderProductsRepository.getByProductIdAndOrderID(orderId.getOrderID(), productId).isPresent()){
                throw new Exception("Product is already exist.");
            }
            OrderProductsT orderProductsT = new OrderProductsT();
            orderProductsT.setCount(count);
            orderProductsT.setOrderID(orderId);
            Optional<Product> productOptional = productServiceImpl.getProductById(productId);
            if(productOptional.isPresent()) {
                orderProductsT.setProductID(productOptional.get());
                orderProductsRepository.save(orderProductsT);
            }
                return this.orderProductsRepository.getByOrderId(orderId.getOrderID());
        }catch(Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void updateCountByOrderId(int count, Long orderID) throws Exception{
        orderProductsRepository.updateCountByOrderId(count, orderID);
    }
}
