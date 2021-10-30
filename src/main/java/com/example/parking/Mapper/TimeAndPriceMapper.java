package com.example.parking.Mapper;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.TimeAndPrice;
import org.springframework.stereotype.Component;

@Component
public class TimeAndPriceMapper {
    public TimeAndPrice to(TimeAndPriceDto tap) {
        return TimeAndPrice.builder()
                .timePlace(tap.getTimePlace())
                .pricePlace(tap.getPricePlace())
                .build();
    }

    public TimeAndPriceDto from(TimeAndPrice timeAndPrice) {
        return TimeAndPriceDto.builder()
                .id(timeAndPrice.getId())
                .timePlace(timeAndPrice.getTimePlace())
                .pricePlace(timeAndPrice.getPricePlace())
                .idCar(timeAndPrice.getCar().getId())
                .idPlace(timeAndPrice.getPlace().getId())
                .build();
    }
}
