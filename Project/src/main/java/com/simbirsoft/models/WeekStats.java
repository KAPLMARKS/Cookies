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
public class WeekStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;

    private int counter;

    private int cabinet;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private UsersT employeeID;

    private Time date;
}
