package com.example.parking.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.validation.constraints.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)

public class CarDto {
        private Long id;

        @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9 -]*$", message = "required.value.error")
        @NotBlank(message = "required.value.error")
        @Size(max = 64, message = "required.value.error")
        private String nameCar;

        @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9 -]*$", message = "required.value.error")
        @NotBlank(message = "required.value.error")
        @Size(max = 64, message = "required.value.error")
        private String numberCar;

        @Min(value = 0, message = "")
        private int numberPlace;

}
