package com.example.__toll_systems.model.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TollTest {
    @Test
    void shouldCreateTollWithParams() {
        Toll toll = buildTollWithParams();

        assertEquals(1, toll.getIdToll());
        assertEquals("São Paulo", toll.getLocation());
        assertEquals(100.0, toll.getBaseRate());
        assertEquals(1, toll.getCars().size());
        assertEquals(1, toll.getMotorcycles().size());
        assertEquals(1, toll.getTrucks().size());
    }

    @Test
    void shouldCreateEmptyToll() {
        Toll toll = new Toll();

        assertNotNull(toll);
        assertNull(toll.getIdToll());
        assertNull(toll.getLocation());
        assertEquals(0.0, toll.getBaseRate());
        assertNull(toll.getCars());
        assertNull(toll.getMotorcycles());
        assertNull(toll.getTrucks());
    }

    private Toll buildTollWithParams() {
        return new Toll(
                1,
                "São Paulo",
                100.0,
                List.of("111-111"),
                List.of("111-111"),
                List.of(buildTruckWithParams())
        );
    }

    private Truck buildTruckWithParams() {
        return new Truck("111-111", 6);
    }
}