package com.simbirsoft.service;

import com.simbirsoft.models.OrderT;
import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.OrderRepository;
import com.simbirsoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UsersServiceImpl usersService;

    @Override
    public void save(OrderT order) {
        orderRepository.save(order);
    }

    @Override
    public void setProductsToOrder(UsersT user, Long orderId){
        Optional<OrderT> optionalOrderT = orderRepository.findById(orderId);
        if (optionalOrderT.isPresent()){
            OrderT orderT = optionalOrderT.get();
            orderT.setProductList(user.getProductList());
            orderRepository.save(orderT);
        }
    }

    @Override
    public List<OrderT> getOrdersByUserId(UsersT user) {
        return orderRepository.getAllByUsersT(user);
    }

    @Override
    public OrderT getOrdersByOrderID(Long id) {
        return orderRepository.getOrderTByOrderID(id);
    }
}
