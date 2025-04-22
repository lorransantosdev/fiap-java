package com.example.__toll_systems.model.response;

import com.example.__toll_systems.model.dto.ValueAndAmount;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TollSystemResponse {

    Map<String, List<ValueAndAmount>> amountCollectedPerLocationOfCars;
    Map<String, List<ValueAndAmount>> amountCollectedPerLocationOfMotorcycles;
    Map<String, List<ValueAndAmount>> amountCollectedPerLocationOfTrucks;

}
