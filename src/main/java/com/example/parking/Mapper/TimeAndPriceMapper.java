package com.example.parking.Mapper;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Entity.TimeAndPrice;
import org.springframework.stereotype.Component;

@Component
public class TimeAndPriceMapper {
    public TimeAndPrice to(TimeAndPriceDto tap) {
        return TimeAndPrice.builder()
                .timePlace(tap.getTimePlace())
                .pricePlace(tap.getPricePlace())
                .car(tap.getCar()).place(tap.getPlace())
                .build();
    }

    public TimeAndPriceDto from(TimeAndPrice timeAndPrice) {
        return TimeAndPriceDto.builder()
                .id(timeAndPrice.getId())
                .timePlace(timeAndPrice.getTimePlace())
                .pricePlace(timeAndPrice.getPricePlace())
                .car(timeAndPrice.getCar())
                .place(timeAndPrice.getPlace())
                .build();
    }
}
