package com.simbirsoft.repositories;

import com.simbirsoft.models.InventoryT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<InventoryT, Long> {
        //мб лонг на продукт надо поменять
        InventoryT findByProductID(Long prodId);

        @Query("update InventoryT inv set inv.counter = :counter where inv.productID = :product_id")
        void setByProdId(@Param("product_id") Long product_id,
                         @Param("counter") Long counter);
}
