package com.simbirsoft.models;

import com.simbirsoft.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    private LocalDate dateGet;

    private Time dateArrived;

    public enum Status{
        DECLINED, WAITING, DELIVERED
    }

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private UsersT staffID;

    private String cabinet;

    @OrderColumn
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> productList;

    @ManyToOne
    private UsersT usersT;

    public OrderT(UsersT usersT){
        this.dateGet = LocalDate.now();
        this.usersT = usersT;
        this.productList = new ArrayList<>();
    }


    public static OrderT castToModel(OrderDto orderDto){
        return OrderT.builder()
                .orderID(orderDto.getOrderID())
                .employeeID(orderDto.getEmployeeID())
                .dateGet(orderDto.getDateGet())
                .dateArrived(orderDto.getDateArrived())
                .status(orderDto.getStatus())
                .staffID(orderDto.getStaffID())
                .cabinet(orderDto.getCabinet())
                .build();
    }
}
