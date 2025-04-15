package com.example.__task_unit_test.model;

import com.example.__task_unit_test.repository.VehicleRentRepository;
import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {

    @NotBlank(message = "O seu nome não pode ser vazio", groups = {VehicleRentRepository.class})
    private String firstName;

    @NotBlank(message = "O modelo do veículo não pode ser vazio", groups = {VehicleRentRepository.class})
    @Size(max = 200, message = "O modelo do veiculo pode ter até 200 caracteres", groups = {VehicleRentRepository.class})
    private String model;

    @NotNull(message = "A quantidade de dias é obrigatória", groups = {VehicleRentRepository.class})
    @Positive(message = "A quantidade de dias deve ser maior que zero", groups = {VehicleRentRepository.class})
    private Integer daysRent;

    @NotNull(message = "A quantidade de dias é obrigatória", groups = {VehicleRentRepository.class})
    @Min(value = 0, message = "A multa por dia não pode ser negativa", groups = {VehicleRentRepository.class})
    private Integer penaltyPerDay;

}
