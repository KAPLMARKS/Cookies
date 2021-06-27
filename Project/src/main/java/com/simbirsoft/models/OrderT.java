package com.simbirsoft.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private UsersT employeeID;

    private Time dateGet;

    private Time dateArrived;

    public enum Status{
        DECLINED, WAITING, DELIVERED
    }

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private UsersT staffID;

    private int cabinet;

}
