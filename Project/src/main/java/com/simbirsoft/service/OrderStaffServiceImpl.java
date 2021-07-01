package com.simbirsoft.service;

import com.simbirsoft.dto.OrderDto;
import com.simbirsoft.models.OrderProductsT;
import com.simbirsoft.models.OrderT;
import com.simbirsoft.repositories.InventoryRepository;
import com.simbirsoft.repositories.OrderProductsRepository;
import com.simbirsoft.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderStaffServiceImpl implements OrderStaffService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    OrderProductsRepository orderProductsRepository;

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
            //если на складе хватает товара return false
            if(checkStorage(optionalOrderT.get()))
                return false;
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
        //два orderT ???

        if (optionalOrderT.isPresent()) {
            //если на складе не хватает товара return false
            if(!checkStorage(optionalOrderT.get())){
                return false;
            }
            //изменяем количество товара на складе
            changeStorage(optionalOrderT.get());

            if (optionalOrderT.get().getStatus().equals(OrderT.Status.WAITING)) {
                orderRepository.setOrderDeliveredStatus(orderT.getOrderID());
                orderDto.setStatus(OrderT.Status.DELIVERED);
                return true;
            }
        }
        return false;
    }

    private boolean checkStorage(OrderT orderT){
        List<OrderProductsT> cart = orderProductsRepository.findByOrderID(orderT.getOrderID());
        //если какого то товара не хватает на складе return false
        for (OrderProductsT order : cart){
            long diff  = order.getCount() - inventoryRepository.findByProductID(order.getProductID()).getCounter();
            if(diff > 0)
                return false;
        }
        return true;
    }
    private void changeStorage(OrderT orderT){
        List<OrderProductsT> cart = orderProductsRepository.findByOrderID(orderT.getOrderID());
        //отнимаем от склада
        for (OrderProductsT order : cart){
            long diff  = inventoryRepository.findByProductID(order.getProductID()).getCounter() - order.getCount();
            inventoryRepository.setByProdId(order.getProductID(), diff);
        }
    }
}

