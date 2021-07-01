package com.simbirsoft.repositories;

import com.simbirsoft.models.Limits;
import com.simbirsoft.models.OrderProductsT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductsRepository extends JpaRepository<OrderProductsT, Long> {
    //мб надо сменить Long orderId на OrderT
    List<OrderProductsT> findByOrderID(Long orderId);

}
