package com.example.__task_unit_test.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRentResponseDtoTest {

    @Test
    void testShouldCreateInstanceUsingAllArgsConstructor() {
        VehicleRentResponseDto dto = new VehicleRentResponseDto(200, "Sucesso", 1500.0);

        assertEquals(200, dto.getReturnCode());
        assertEquals("Sucesso", dto.getReturnMessage());
        assertEquals(1500.0, dto.getReturnValueOfRent());
    }

    @Test
    void testShouldCreateInstanceUsingNoArgsConstructorAndSetters() {
        VehicleRentResponseDto dto = new VehicleRentResponseDto();
        dto.setReturnCode(400);
        dto.setReturnMessage("Erro de validação");
        dto.setReturnValueOfRent(0.0);

        assertEquals(400, dto.getReturnCode());
        assertEquals("Erro de validação", dto.getReturnMessage());
        assertEquals(0.0, dto.getReturnValueOfRent());
    }

    @Test
    void testShouldCompareTwoInstances() {
        VehicleRentResponseDto dto1 = new VehicleRentResponseDto(200, "OK", 123.45);
        VehicleRentResponseDto dto2 = new VehicleRentResponseDto(200, "OK", 123.45);

        assertEquals(dto1.getReturnCode(), dto2.getReturnCode());
        assertEquals(dto1.getReturnMessage(), dto2.getReturnMessage());
        assertEquals(dto1.getReturnValueOfRent(), dto2.getReturnValueOfRent());
    }
}