package com.example.__toll_systems.repository.impl;

import com.example.__toll_systems.model.dto.Toll;
import com.example.__toll_systems.model.dto.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TollSystemRepositoryImplTest {

    @Spy
    private TollSystemRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShouldSaveTollsCorrectly() {
        Toll toll1 = buildToll(1, "São Paulo");
        Toll toll2 = buildToll(2, "Campinas");

        repository.saveTolls(List.of(toll1, toll2));

        assertDoesNotThrow(() -> repository.saveTolls(List.of(toll1, toll2)));
    }

    @Test
    void testShouldReplacePreviousTolls() {
        Toll toll1 = buildToll(1, "São Paulo");
        Toll toll2 = buildToll(2, "Campinas");
        Toll toll3 = buildToll(3, "Ribeirão Preto");

        repository.saveTolls(List.of(toll1, toll2));
        repository.saveTolls(List.of(toll3));

        assertDoesNotThrow(() -> repository.saveTolls(List.of(toll3)));
    }

    private Toll buildToll(Integer id, String location) {
        return new Toll(
                id,
                location,
                100.0,
                List.of("ABC-1234"),
                List.of("XYZ-9876"),
                List.of(new Truck("TRK-1122", 6))
        );
    }
}