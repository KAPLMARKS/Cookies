package com.simbirsoft.dto;

import com.simbirsoft.models.OrderT;
import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long orderID;
    private UsersT employeeID;
    private LocalDate dateGet;
    private Time dateArrived;
    private OrderT.Status status;
    private UsersT staffID;
    private String cabinet;


    public static OrderDto from(OrderT order){
        return OrderDto.builder()
                .orderID(order.getOrderID())
                .employeeID(order.getEmployeeID())
                .dateGet(order.getDateGet())
                .dateArrived(order.getDateArrived())
                .status(order.getStatus())
                .staffID(order.getStaffID())
                .cabinet(order.getCabinet())
                .build();
    }


    public static List<OrderDto> from(List<OrderT> orders) {
        return orders.stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }
}
