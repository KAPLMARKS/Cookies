package com.simbirsoft.repositories;

import com.simbirsoft.models.OrderProductsT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderProductsRepository extends JpaRepository<OrderProductsT, Long> {

    @Query("update OrderProductsT orderProductsT set orderProductsT.count=:count WHERE orderProductsT.orderID=: order_id")
    void updateCountByOrderId(@Param("order_id")Long order_id, @Param("count")Integer count);

    @Query("Select orderProductsT FROM OrderProductsT orderProductsT WHERE orderProductsT.productID= :product_id and orderProductsT.orderID=:order_id")
    Optional<OrderProductsT> getByProductIdAndOrderID(@Param("product_id")Long product_id, @Param("order_id")Long order_id);

    @Query("Select orderProductsT  FROM OrderProductsT orderProductsT WHERE orderProductsT.orderID=:order_id")
    List<OrderProductsT> getByOrderId(@Param("order_id")Long order_id);
}
