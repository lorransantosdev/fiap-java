package com.example.__toll_systems.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Toll {

    private Integer idToll;
    private String location;
    private double baseRate;
    private List<Car> cars;
    private List<Motorcycle> motorcycles;
    private List<Truck> trucks;
}
