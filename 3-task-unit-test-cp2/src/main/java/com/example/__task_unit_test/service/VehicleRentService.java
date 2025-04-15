package com.example.__task_unit_test.service;

import com.example.__task_unit_test.dto.VehicleRentResponseDto;
import com.example.__task_unit_test.model.VehicleRequest;
import com.example.__task_unit_test.repository.impl.VehicleRentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleRentService {

    @Autowired
    private VehicleRentRepositoryImpl repository;

    public ResponseEntity<VehicleRentResponseDto> rentStarting(VehicleRequest request) {
        try {
            double total = calculateValueTotal(request);
            Integer totalDaysRent = request.getDaysRent() + request.getPenaltyPerDay();
            String message = String.format("Veiculo %s devolvido com sucesso referente à %d dias",
                    request.getModel(), totalDaysRent);

            return ResponseEntity.ok(
                    new VehicleRentResponseDto(200, message, total)
            );

        } catch (Exception e) {
            throw e;
        }
    }

    public double calculateValueTotal(VehicleRequest request) {
        String model = validVehicle(request);
        if (model.isBlank()) {
            throw new IllegalArgumentException("Veiculo não encontrado para devolução");
        }

        double rentalPricePerDay = repository.findValueRent();

        if (request.getPenaltyPerDay() == 0) {
            rentalPricePerDay = calculateDiscount(rentalPricePerDay);
            return calculateValueTotal(request, rentalPricePerDay);
        }

        rentalPricePerDay = calculateFine(rentalPricePerDay);

        return calculateValueTotal(request, rentalPricePerDay);
    }

    public String validVehicle(VehicleRequest request) {
        return repository.vehicleExistent().stream()
                .filter(model -> model.equalsIgnoreCase(request.getModel()))
                .findFirst()
                .orElse("");
    }

    public double calculateDiscount(double retalPricePerDay) {
        return retalPricePerDay - (retalPricePerDay * 0.10);
    }

    public double calculateFine(double retalPricePerDay) {
        return retalPricePerDay + retalPricePerDay * 0.20;
    }

    public double calculateValueTotal(VehicleRequest request, double retalPricePerDay) {
        return request.getDaysRent() * retalPricePerDay;
    }

}
