package com.simbirsoft.models;

import com.simbirsoft.dto.LimitDto;
import com.simbirsoft.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Limit {

    @Id
    private long userId;
    private long productId;
    private int dayTimer;
    private int dayCounter = 0;
    private int quantLimit;
    private int quantCounter = 0;

    public static Limit castToModel(LimitDto lim){
        return Limit.builder()
                .userId(lim.getUserId())
                .productId(lim.getProductId())
                .dayTimer(lim.getDayTimer())
                .quantLimit(lim.getQuantLimit())
                .quantCounter(lim.getQuantCounter())
                .dayCounter(lim.getDayCounter())
                .build();
    }

}
