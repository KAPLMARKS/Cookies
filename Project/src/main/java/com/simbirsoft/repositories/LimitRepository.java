package com.simbirsoft.repositories;

import com.simbirsoft.models.Limits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface LimitRepository extends JpaRepository<Limits, Long> {

    List<Limits> findByUserId(Long userId);


    @Modifying
    @Query(value = "insert into limits (user_id, days, days_counter, product_id, quantity, quantity_counter) " +
            "values (:user_id, :days, :days_counter, :product_id, :quantity, :quantity_counter)", nativeQuery = true)
    void addNewLimit(@Param("user_id") Long user_id,
                     @Param("days") Long days,
                     @Param("days_counter") Long days_counter,
                     @Param("product_id") Long product_id,
                     @Param("quantity") Long quantity,
                     @Param("quantity_counter") Long quantity_counter
    );

    @Query("update Limits l " +
            "set l.days = :days, l.quantity = :quantity " +
            "where l.userId = :user_id and l.productId = :product_id")
    void changeLimit(@Param("user_id") Long user_id,
                     @Param("days") Long days,
                     @Param("product_id") Long product_id,
                     @Param("quantity") Long quantity
    );
}