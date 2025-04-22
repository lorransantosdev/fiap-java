package com.example.__toll_systems.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueAndAmountTest {

    @Test
    void testShouldConstructorWhenThereAreParams() {
        ValueAndAmount valueAndAmount = buildValueAndAmountWithParams();

        assertEquals(100, valueAndAmount.getTotalValue());
        assertEquals(1, valueAndAmount.getAmount());
    }


    @Test
    void testShouldConstructorWhenNotParams() {
        ValueAndAmount valueAndAmount = new ValueAndAmount();

        assertEquals(0.0, valueAndAmount.getTotalValue());
        assertEquals(0, valueAndAmount.getAmount());
    }

    public ValueAndAmount buildValueAndAmountWithParams() {
        return new ValueAndAmount(100, 1);
    }

}