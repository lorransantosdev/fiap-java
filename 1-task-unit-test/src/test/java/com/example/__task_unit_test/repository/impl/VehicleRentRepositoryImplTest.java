package com.example.__task_unit_test.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRentRepositoryImplTest {

    @Spy
    private VehicleRentRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShouldReturnRandomRentValueWithinExpectedRange() {
        for (int i = 0; i < 100; i++) {
            double value = repository.findValueRent();
            assertTrue(value >= 1000 && value < 3000,
                    "Valor do aluguel deve estar entre 1000 e 2999, mas foi: " + value);
        }
    }

    @Test
    void testShouldReturnListOfExistingVehicleModels() {
        List<String> models = repository.vehicleExistent();

        assertNotNull(models);
        assertEquals(12, models.size());
        assertTrue(models.contains("Volkswagen Jetta"));
        assertTrue(models.contains("Fiat Uno"));
    }
}