package com.example.__toll_systems.service;

import com.example.__toll_systems.model.TollSystemRequest;
import com.example.__toll_systems.model.dto.Truck;
import com.example.__toll_systems.model.dto.Toll;
import com.example.__toll_systems.model.dto.ValueAndAmount;
import com.example.__toll_systems.model.response.TollSystemResponse;
import com.example.__toll_systems.repository.TollSystemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class TollSystemServiceTest {

    @InjectMocks
    private TollSystemService service;

    @Mock
    private TollSystemRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSystemControlOfToll_comVeiculos() {
        // Arrange
        Toll toll = new Toll(
                1,
                "Local1",
                10.0,
                List.of("111-111", "222-222", "333-333"),
                List.of("M1", "M2"),
                List.of(new Truck("T1", 2), new Truck("T2", 3))
        );
        TollSystemRequest request = new TollSystemRequest(List.of(toll));

        ResponseEntity<TollSystemResponse> responseEntity = service.systemControlOfToll(request);

        verify(repository).saveTolls(request.getTollsInfo());

        TollSystemResponse response = responseEntity.getBody();
        assertNotNull(response, "O corpo da resposta não pode ser nulo");

        Map<String, List<ValueAndAmount>> carsMap = response.getAmountCollectedPerLocationOfCars();
        ValueAndAmount carData = carsMap.get("Local1").get(0);
        assertEquals(3, carData.getAmount(), "A quantidade de carros deve corresponder");
        assertEquals(3 * 10.0, carData.getTotalValue(), 0.0001, "Valor total de carros incorreto");

        Map<String, List<ValueAndAmount>> motoMap = response.getAmountCollectedPerLocationOfMotorcycles();
        ValueAndAmount motoData = motoMap.get("Local1").get(0);
        assertEquals(2, motoData.getAmount(), "A quantidade de motocicletas deve corresponder");
        assertEquals(2 * (10.0 * 0.5), motoData.getTotalValue(), 0.0001, "Valor total de motocicletas incorreto");

        Map<String, List<ValueAndAmount>> truckMap = response.getAmountCollectedPerLocationOfTrucks();
        ValueAndAmount truckData = truckMap.get("Local1").get(0);

        assertEquals(2, truckData.getAmount(), "A quantidade de caminhões deve corresponder");
        assertEquals((2 * 10.0) + (3 * 10.0), truckData.getTotalValue(), 0.0001, "Valor total de caminhões incorreto");
    }

    @Test
    void testSystemControlOfToll_comListasNulasEVazias() {
        Toll tollNull = new Toll(2, "LocalNulo", 0.0, null, null, null);
        Toll tollEmpty = new Toll(3, "LocalVazio", 5.0, List.of(), List.of(), List.of());
        TollSystemRequest request = new TollSystemRequest(List.of(tollNull, tollEmpty));

        ResponseEntity<TollSystemResponse> responseEntity = service.systemControlOfToll(request);

        verify(repository).saveTolls(request.getTollsInfo());

        TollSystemResponse response = responseEntity.getBody();
        assertNotNull(response, "O corpo da resposta não pode ser nulo");

        ValueAndAmount carNull = response.getAmountCollectedPerLocationOfCars().get("LocalNulo").get(0);
        assertEquals(0, carNull.getAmount());
        assertEquals(0.0, carNull.getTotalValue(), 0.0001);

        ValueAndAmount motoNull = response.getAmountCollectedPerLocationOfMotorcycles().get("LocalNulo").get(0);
        assertEquals(0, motoNull.getAmount());
        assertEquals(0.0, motoNull.getTotalValue(), 0.0001);

        ValueAndAmount truckNull = response.getAmountCollectedPerLocationOfTrucks().get("LocalNulo").get(0);
        assertEquals(0, truckNull.getAmount());
        assertEquals(0.0, truckNull.getTotalValue(), 0.0001);

        ValueAndAmount carEmpty = response.getAmountCollectedPerLocationOfCars().get("LocalVazio").get(0);
        assertEquals(0, carEmpty.getAmount());
        assertEquals(0.0, carEmpty.getTotalValue(), 0.0001);

        ValueAndAmount motoEmpty = response.getAmountCollectedPerLocationOfMotorcycles().get("LocalVazio").get(0);
        assertEquals(0, motoEmpty.getAmount());
        assertEquals(0.0, motoEmpty.getTotalValue(), 0.0001);

        ValueAndAmount truckEmpty = response.getAmountCollectedPerLocationOfTrucks().get("LocalVazio").get(0);
        assertEquals(0, truckEmpty.getAmount());
        assertEquals(0.0, truckEmpty.getTotalValue(), 0.0001);
    }
}
