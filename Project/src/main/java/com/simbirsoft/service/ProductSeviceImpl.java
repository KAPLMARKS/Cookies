package com.simbirsoft.service;

import com.simbirsoft.dto.ProductDto;
import com.simbirsoft.models.Product;
import com.simbirsoft.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSeviceImpl implements ProductSevice {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductDto.from(products);
    }
}
