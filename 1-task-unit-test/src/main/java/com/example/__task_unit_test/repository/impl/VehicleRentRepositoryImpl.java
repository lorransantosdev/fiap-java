package com.example.__task_unit_test.repository.impl;

import com.example.__task_unit_test.repository.VehicleRentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class VehicleRentRepositoryImpl implements VehicleRentRepository {

    private static final String[] MODELS = {
            "Fiat Uno", "Chevrolet Onix", "Volkswagen Gol", "Ford Ka", "Renault Kwid",
            "Toyota Corolla", "Hyundai HB20", "Honda Civic", "Jeep Renegade", "Peugeot 208",
            "Volkswagen Jetta", "Volkswagen Golf"
    };


    @Override
    public double findValueRent() {
        Random random = new Random();
        return 1000 + random.nextInt(2000);
    }


    @Override
    public List<String> vehicleExistent() {
        List<String> modelVehicles = new ArrayList<>();
        for (int i = 0; i < MODELS.length; i++) {
            modelVehicles.add(MODELS[i]);
        }
        return modelVehicles;
    }

}