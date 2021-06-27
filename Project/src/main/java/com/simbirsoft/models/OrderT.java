package com.simbirsoft.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderT {
    private int orderID;
    private int employeeID;
    private Time dateGet;
    private Time dateArrived;
    private Status status;
    private int staffID;
    private int cabinet;

}
enum Status{
    DECLINED("Отклонен"),
    WAITING("На рассмотрении"),
    DELIVERED("Доставлен");
    public final String message;

    Status(String message) {
        this.message = message;
    }
}
