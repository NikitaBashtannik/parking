package com.example.parking.Dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.Min;
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

    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9 -]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String timePlace;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9 -]*$", message = "required.value.error")
    @NotBlank(message = "required.value.error")
    @Size(max = 64, message = "required.value.error")
    private String pricePlace;

    @Min(value = 0, message = "")
    private Long idCar;

    @Min(value = 0,message = "")
    private Long idPlace;
}
