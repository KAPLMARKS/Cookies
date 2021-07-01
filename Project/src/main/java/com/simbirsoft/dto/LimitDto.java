package com.simbirsoft.dto;

import com.simbirsoft.models.Limits;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class LimitDto {
    private Long userId;
    private Long productId;
    private Long days;
    private Long daysCounter = 0l;
    private Long quantity;
    private Long quantityCounter = 0l;

    public static LimitDto castToDto(Limits limits){
        return LimitDto.builder()
                .userId(limits.getUserId())
                .productId(limits.getProductId())
                .days(limits.getDays())
                .quantity(limits.getQuantity())
                .quantityCounter(limits.getQuantityCounter())
                .daysCounter(limits.getDaysCounter())
                .build();
    }
}