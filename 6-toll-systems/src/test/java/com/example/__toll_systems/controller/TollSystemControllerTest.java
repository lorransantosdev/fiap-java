package com.example.__toll_systems.controller;

import com.example.__toll_systems.model.TollSystemRequest;
import com.example.__toll_systems.model.dto.Toll;
import com.example.__toll_systems.model.dto.Truck;
import com.example.__toll_systems.model.dto.ValueAndAmount;
import com.example.__toll_systems.model.response.TollSystemResponse;
import com.example.__toll_systems.service.TollSystemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TollSystemControllerTest {

    @InjectMocks
    private TollSystemController controller;

    @Mock
    private TollSystemService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShouldReturnSuccessResponse() {
        TollSystemRequest request = buildTollSystemRequest();
        TollSystemResponse expectedResponse = buildTollSystemResponse();

        when(service.systemControlOfToll(any())).thenReturn(ResponseEntity.ok(expectedResponse));

        ResponseEntity<TollSystemResponse> response = controller.systemControlOfTolls(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
    }

    private TollSystemRequest buildTollSystemRequest() {
        return new TollSystemRequest(List.of(
                new Toll(
                        1,
                        "São Paulo",
                        100.0,
                        List.of("ABC-1234"),
                        List.of("XYZ-9876"),
                        List.of(new Truck("TRK-1122", 6))
                )
        ));
    }

    private TollSystemResponse buildTollSystemResponse() {
        return TollSystemResponse.builder()
                .amountCollectedPerLocationOfCars(Map.of("São Paulo", List.of(new ValueAndAmount(100.0, 1))))
                .amountCollectedPerLocationOfMotorcycles(Map.of("São Paulo", List.of(new ValueAndAmount(50.0, 1))))
                .amountCollectedPerLocationOfTrucks(Map.of("São Paulo", List.of(new ValueAndAmount(600.0, 1))))
                .build();
    }

}