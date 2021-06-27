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
public class WeekStats {
    private int productID;
    private int counter;
    private int cabinet;
    private int employeeID;
    private Time date;
}
