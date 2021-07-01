package com.simbirsoft.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderProductsT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //изменил тип и убрал аннотацию ManyToOne
    @JoinColumn(name = "order_id")
    private Long orderID;

    //изменил тип и убрал аннотацию ManyToOne
    @JoinColumn(name = "product_id")
    private Long productID;

    private int count;

}
