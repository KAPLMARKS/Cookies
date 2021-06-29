package com.simbirsoft.dto;

import com.simbirsoft.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;

    public static ProductDto from(Product product){
        return ProductDto.builder()
                .id(product.getProductID())
                .name(product.getProductName())
                .build();
    }

    public static List<ProductDto> from(List<Product> products){
        return products.stream()
                .map(ProductDto::from)
                .collect(Collectors.toList());
    }
}
