package com.simbirsoft.dto;

import com.simbirsoft.models.Limit;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class LimitDto {
    private Long userId;
    private long productId;
    private int dayTimer;
    private int dayCounter = 0;
    private int quantLimit;
    private int quantCounter = 0;

    public static LimitDto castToDto(Limit limit){
        return LimitDto.builder()
                .userId(limit.getUserId())
                .productId(limit.getProductId())
                .dayTimer(limit.getDayTimer())
                .quantLimit(limit.getQuantLimit())
                .quantCounter(limit.getQuantCounter())
                .dayCounter(limit.getDayCounter())
                .build();
    }
}
