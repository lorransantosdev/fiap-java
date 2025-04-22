package com.example.__toll_systems.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void testShouldConstructorWhenThereAreParams() {
        Truck truck = buildTruckWithParams();

        assertEquals("111-111", truck.getPlateTruck());
        assertEquals(6, truck.getAxis());
    }


    @Test
    void testShouldConstructorWhenNotParams() {
        Truck truck = new Truck();

        assertEquals(null, truck.getPlateTruck());
        assertEquals(0, truck.getAxis());
    }

    public Truck buildTruckWithParams() {
        return new Truck("111-111", 6);
    }

}