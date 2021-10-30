package com.example.parking.Dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeAndPriceDto {
    private Long id;

    @Pattern(regexp = "^[0-9-:]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String timePlace;

    @Pattern(regexp = "^[а-яА-ЯA-z0-9]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String pricePlace;

    private Long idCar;

    private Long idPlace;
}
