package com.example.__toll_systems.model.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Toll {

    private Integer idToll;
    private String location;
    private double baseRate;
    private List<String> cars;
    private List<String> motorcycles;
    private List<Truck> trucks;
}
