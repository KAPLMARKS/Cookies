package com.simbirsoft.models;

import com.simbirsoft.dto.LimitDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Limits implements Serializable {

    @Id
    private Long userId;
    @Column
    private Long productId;
    @Column
    private Long days;
    @Column
    private Long daysCounter = 0l;
    @Column
    private Long quantity;
    @Column
    private Long quantityCounter = 0l;

    public static Limits castToModel(LimitDto lim){
        return Limits.builder()
                .userId(lim.getUserId())
                .productId(lim.getProductId())
                .days(lim.getDays())
                .quantity(lim.getQuantity())
                .quantityCounter(lim.getQuantityCounter())
                .daysCounter(lim.getDaysCounter())
                .build();
    }

}
