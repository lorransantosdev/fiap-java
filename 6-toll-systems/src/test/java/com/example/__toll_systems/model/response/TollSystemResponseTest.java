package com.example.__toll_systems.model.response;

import com.example.__toll_systems.model.dto.ValueAndAmount;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TollSystemResponseTest {

    @Test
    void shouldCreateTollSystemResponseWithAllArgsConstructor() {
        TollSystemResponse response = new TollSystemResponse(
                Map.of("São Paulo", List.of(new ValueAndAmount(100.0, 1))),
                Map.of("São Paulo", List.of(new ValueAndAmount(50.0, 2))),
                Map.of("São Paulo", List.of(new ValueAndAmount(300.0, 1)))
        );

        assertNotNull(response);
        assertEquals(1, response.getAmountCollectedPerLocationOfCars().size());
        assertEquals(1, response.getAmountCollectedPerLocationOfMotorcycles().size());
        assertEquals(1, response.getAmountCollectedPerLocationOfTrucks().size());
    }

    @Test
    void shouldCreateTollSystemResponseWithNoArgsConstructorAndSetters() {
        TollSystemResponse response = new TollSystemResponse();

        response.setAmountCollectedPerLocationOfCars(Map.of("São Paulo", List.of(new ValueAndAmount(120.0, 3))));
        response.setAmountCollectedPerLocationOfMotorcycles(Map.of("Campinas", List.of(new ValueAndAmount(30.0, 1))));
        response.setAmountCollectedPerLocationOfTrucks(Map.of("Ribeirão Preto", List.of(new ValueAndAmount(400.0, 2))));

        assertNotNull(response);
        assertEquals(120.0, response.getAmountCollectedPerLocationOfCars().get("São Paulo").get(0).getTotalValue());
        assertEquals(30.0, response.getAmountCollectedPerLocationOfMotorcycles().get("Campinas").get(0).getTotalValue());
        assertEquals(400.0, response.getAmountCollectedPerLocationOfTrucks().get("Ribeirão Preto").get(0).getTotalValue());
    }

    @Test
    void shouldCreateTollSystemResponseWithBuilder() {
        TollSystemResponse response = TollSystemResponse.builder()
                .amountCollectedPerLocationOfCars(Map.of("São Paulo", List.of(new ValueAndAmount(200.0, 5))))
                .amountCollectedPerLocationOfMotorcycles(Map.of("Campinas", List.of(new ValueAndAmount(70.0, 3))))
                .amountCollectedPerLocationOfTrucks(Map.of("Ribeirão Preto", List.of(new ValueAndAmount(800.0, 4))))
                .build();

        assertNotNull(response);
        assertEquals(5, response.getAmountCollectedPerLocationOfCars().get("São Paulo").get(0).getAmount());
        assertEquals(3, response.getAmountCollectedPerLocationOfMotorcycles().get("Campinas").get(0).getAmount());
        assertEquals(4, response.getAmountCollectedPerLocationOfTrucks().get("Ribeirão Preto").get(0).getAmount());
    }

}