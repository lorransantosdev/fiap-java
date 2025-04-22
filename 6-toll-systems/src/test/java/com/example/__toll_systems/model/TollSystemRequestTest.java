package com.example.__toll_systems.model;

import com.example.__toll_systems.model.dto.Toll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TollSystemRequestTest {

    @Test
    void shouldCreateTollSystemRequestWithParams() {
        List<Toll> tolls = List.of(buildTollWithParams());
        TollSystemRequest request = new TollSystemRequest(tolls);

        assertNotNull(request);
        assertEquals(1, request.getTollsInfo().size());
        assertEquals("São Paulo", request.getTollsInfo().get(0).getLocation());
    }

    @Test
    void shouldCreateEmptyTollSystemRequest() {
        TollSystemRequest request = new TollSystemRequest();

        assertNotNull(request);
        assertNull(request.getTollsInfo());
    }

    private Toll buildTollWithParams() {
        return new Toll(
                1,
                "São Paulo",
                100.0,
                List.of("111-111"),
                List.of("111-111"),
                List.of(new com.example.__toll_systems.model.dto.Truck("111-111", 6))
        );
    }

}