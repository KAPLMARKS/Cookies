package com.simbirsoft.service;

import com.simbirsoft.dto.ProductDto;
import com.simbirsoft.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();

    Optional<Product> getProductById(Long id);
}
