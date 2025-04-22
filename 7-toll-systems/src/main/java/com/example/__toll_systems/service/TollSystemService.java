package com.example.__toll_systems.service;

import com.example.__toll_systems.model.TollSystemRequest;
import com.example.__toll_systems.model.dto.Toll;
import com.example.__toll_systems.model.dto.ValueAndAmount;
import com.example.__toll_systems.model.response.TollSystemResponse;
import com.example.__toll_systems.repository.TollSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TollSystemService {

    @Autowired
    private TollSystemRepository repository;

    public ResponseEntity<TollSystemResponse> systemControlOfToll(TollSystemRequest request) {
        repository.saveTolls(request.getTollsInfo());

        Map<String, List<ValueAndAmount>> carsMap = new HashMap<>();
        Map<String, List<ValueAndAmount>> motorcyclesMap = new HashMap<>();
        Map<String, List<ValueAndAmount>> trucksMap = new HashMap<>();

        for (Toll toll : request.getTollsInfo()) {
            carsMap.put(toll.getLocation(), List.of(calculateCarData(toll)));
            motorcyclesMap.put(toll.getLocation(), List.of(calculateMotorcycleData(toll)));
            trucksMap.put(toll.getLocation(), List.of(calculateTruckData(toll)));
        }

        TollSystemResponse response = TollSystemResponse.builder()
                .amountCollectedPerLocationOfCars(carsMap)
                .amountCollectedPerLocationOfMotorcycles(motorcyclesMap)
                .amountCollectedPerLocationOfTrucks(trucksMap)
                .build();

        return ResponseEntity.ok(response);
    }

    private ValueAndAmount calculateCarData(Toll toll) {
        double baseRate = Optional.of(toll.getBaseRate()).orElse(0.0);

        return Optional.ofNullable(toll.getCars())
                .map(cars -> new ValueAndAmount(cars.size() * baseRate, cars.size()))
                .orElse(new ValueAndAmount(0.0, 0));
    }

    private ValueAndAmount calculateMotorcycleData(Toll toll) {
        double baseRate = Optional.of(toll.getBaseRate()).orElse(0.0);

        return Optional.ofNullable(toll.getMotorcycles())
                .map(motos -> new ValueAndAmount(motos.size() * (baseRate * 0.5), motos.size()))
                .orElse(new ValueAndAmount(0.0, 0));
    }

    private ValueAndAmount calculateTruckData(Toll toll) {
        double baseRate = Optional.of(toll.getBaseRate()).orElse(0.0);

        return Optional.ofNullable(toll.getTrucks())
                .map(trucks -> new ValueAndAmount(
                        trucks.stream().mapToDouble(truck -> baseRate * truck.getAxis()).sum(),
                        trucks.size()))
                .orElse(new ValueAndAmount(0.0, 0));
    }

}
