package com.simbirsoft.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productID;
    private String productName;
    // изначально в таблице указано как type - varchar, делать ли enum?
    // не надо делать enum мы не знаем что у нас за продукты вообще

}
