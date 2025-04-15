package com.example.__task_unit_test.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleRequestTest {

    @Test
    void testShouldCreateInstanceWithNoArgsConstructorAndSetters() {
        VehicleRequest request = new VehicleRequest();
        request.setFirstName("Lorran");
        request.setModel("Volkswagen Jetta");
        request.setDaysRent(5);
        request.setPenaltyPerDay(2);

        assertEquals("Lorran", request.getFirstName());
        assertEquals("Volkswagen Jetta", request.getModel());
        assertEquals(5, request.getDaysRent());
        assertEquals(2, request.getPenaltyPerDay());
    }

    @Test
    void testShouldCreateInstanceWithAllArgsConstructor() {
        VehicleRequest request = new VehicleRequest("Lorran", "Toyota Corolla", 7, 1);

        assertNotNull(request);
        assertEquals("Lorran", request.getFirstName());
        assertEquals("Toyota Corolla", request.getModel());
        assertEquals(7, request.getDaysRent());
        assertEquals(1, request.getPenaltyPerDay());
    }
}