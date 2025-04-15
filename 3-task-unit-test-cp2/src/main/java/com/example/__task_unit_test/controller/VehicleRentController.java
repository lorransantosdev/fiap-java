package com.example.__task_unit_test.controller;

import com.example.__task_unit_test.dto.VehicleRentResponseDto;
import com.example.__task_unit_test.model.VehicleRequest;
import com.example.__task_unit_test.repository.VehicleRentRepository;
import com.example.__task_unit_test.service.VehicleRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
public class VehicleRentController {

    @Autowired
    private VehicleRentService vehicleRentService;

    @PostMapping("/rentvehicle")
    public ResponseEntity<VehicleRentResponseDto> rentVehicle(
            @Validated ({VehicleRentRepository.class})
            @RequestBody VehicleRequest request) {

        return vehicleRentService.rentStarting(request);
    }
}
