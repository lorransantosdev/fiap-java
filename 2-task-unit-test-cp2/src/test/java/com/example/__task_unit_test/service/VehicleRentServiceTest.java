package com.example.__task_unit_test.service;

import com.example.__task_unit_test.dto.VehicleRentResponseDto;
import com.example.__task_unit_test.model.VehicleRequest;
import com.example.__task_unit_test.repository.impl.VehicleRentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleRentServiceTest {

    @InjectMocks
    private VehicleRentService service;

    @Mock
    private VehicleRentRepositoryImpl repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testShouldCalculateDiscountWhenNoPenalty() {
        VehicleRequest request = buildRequest(0);

        when(repository.vehicleExistent()).thenReturn(List.of("Volkswagen Jetta"));
        when(repository.findValueRent()).thenReturn(1000.0);

        ResponseEntity<VehicleRentResponseDto> response = service.rentStarting(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(9000.0, response.getBody().getReturnValueOfRent());
        assertTrue(response.getBody().getReturnMessage().contains("Volkswagen Jetta"));
    }

    @Test
    void testShouldCalculateFineWhenPenaltyExists() {
        VehicleRequest request = buildRequest(2);

        when(repository.vehicleExistent()).thenReturn(List.of("Volkswagen Jetta"));
        when(repository.findValueRent()).thenReturn(1000.0); // valor base

        ResponseEntity<VehicleRentResponseDto> response = service.rentStarting(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(12000.0, response.getBody().getReturnValueOfRent());
        assertTrue(response.getBody().getReturnMessage().contains("12"));
    }

    @Test
    void testShouldReturnInternalServerErrorWhenModelIsInvalid() {
        VehicleRequest request = buildRequest(1);
        request.setModel("Modelo Inexistente");

        when(repository.vehicleExistent()).thenReturn(List.of("Outro veiculo"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.rentStarting(request);
        });

        assertEquals("Veiculo não encontrado para devolução", exception.getMessage());
    }

    @Test
    void testShouldCalculateFineCorrectly() {
        double result = service.calculateFine(1000.0);
        assertEquals(1200.0, result);
    }

    @Test
    void testShouldCalculateDiscountCorrectly() {
        double result = service.calculateDiscount(1000.0);
        assertEquals(900.0, result);
    }

    @Test
    void testShouldValidateVehicleSuccessfully() {
        VehicleRequest request = buildRequest(0);
        when(repository.vehicleExistent()).thenReturn(List.of("Volkswagen Jetta"));

        String model = service.validVehicle(request);

        assertTrue(model.contains("Volkswagen Jetta"));
    }

    @Test
    void testShouldReturnEmptyWhenVehicleInvalid() {
        VehicleRequest request = buildRequest(0);
        when(repository.vehicleExistent()).thenReturn(List.of("Outro Modelo"));

        String model = service.validVehicle(request);

        assertFalse(model.contains("Volkswagen Jetta"));
        assertTrue(model.isEmpty() || model.equals("Optional.empty"));
    }

    private VehicleRequest buildRequest(int penaltyPerDay) {
        return new VehicleRequest(
                "Lorran",
                "Volkswagen Jetta",
                10,
                penaltyPerDay
        );
    }
}