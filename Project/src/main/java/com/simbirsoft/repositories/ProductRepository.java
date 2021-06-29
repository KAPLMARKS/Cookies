package com.simbirsoft.repositories;

import com.simbirsoft.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
