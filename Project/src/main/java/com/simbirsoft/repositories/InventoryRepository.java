package com.simbirsoft.repositories;

import com.simbirsoft.models.InventoryT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryT, Long> {

}
