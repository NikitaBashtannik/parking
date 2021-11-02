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
    private String time;

    @Pattern(regexp = "[А-Я]\\d{3}[А-Я]{2}\\d{2,3}", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String price;

    private Long idCar;

    private Long idPlace;
}
