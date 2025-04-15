package com.example.__task_unit_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRentResponseDto {

    private int returnCode;
    private String returnMessage;
    private double returnValueOfRent;

}
