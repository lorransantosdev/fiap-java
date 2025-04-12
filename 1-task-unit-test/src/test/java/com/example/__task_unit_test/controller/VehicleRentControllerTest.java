package com.example.__task_unit_test.controller;

import com.example.__task_unit_test.dto.VehicleRentResponseDto;
import com.example.__task_unit_test.model.VehicleRequest;
import com.example.__task_unit_test.service.VehicleRentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class VehicleRentControllerTest {

    @InjectMocks
    private VehicleRentController controller;

    @Mock
    private VehicleRentService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnSuccessResponse() {
        VehicleRequest request = buildVehicleRequest();
        VehicleRentResponseDto dto = new VehicleRentResponseDto(200, "Success", 10000.0);

        when(service.rentStarting(any())).thenReturn(ResponseEntity.ok(dto));

        ResponseEntity<VehicleRentResponseDto> response = controller.rentVehicle(request);

        assertEquals("Success", response.getBody().getReturnMessage());
        assertEquals(10000.0, response.getBody().getReturnValueOfRent());
    }

    public VehicleRequest buildVehicleRequest() {
        VehicleRequest request = new VehicleRequest();
        request.setFirstName("Lorran");
        request.setModel("Volkswagen Jetta");
        request.setDaysRent(10);
        request.setPenaltyPerDay(10);
        return request;
    }
}