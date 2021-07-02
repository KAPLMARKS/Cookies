package com.simbirsoft.repositories;

import com.simbirsoft.models.OrderT;
import com.simbirsoft.models.UsersT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderT, Long> {

    List<OrderT> findAll();

    @Override
    Optional<OrderT> findById(Long orderID);

    @Query("UPDATE OrderT o SET o.status ='DECLINED' where o.orderID=:id")
    void setOrderDeclinedStatus(@Param("id") Long id);

    @Query("UPDATE OrderT o SET o.status ='WAITING' where o.orderID=:id")
    void setOrderWaitingStatus(@Param("id") Long id);

    @Query("UPDATE OrderT o SET o.status ='DELIVERED' where o.orderID=:id")
    void setOrderDeliveredStatus(@Param("id") Long id);

    List<OrderT> getAllByUsersT(UsersT user);

    OrderT getOrderTByOrderID(Long id);

}
