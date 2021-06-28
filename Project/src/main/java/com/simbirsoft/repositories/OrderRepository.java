package com.simbirsoft.repositories;

import com.simbirsoft.models.OrderT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderT, Long> {
}
