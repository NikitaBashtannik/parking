package com.example.parking.Mapper;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Entity.TimeAndPrice;

public class TimeAndPriceMapper {
    public TimeAndPrice to(TimeAndPriceDto tap){
        return TimeAndPrice.builder().timePlace(tap.getTimePlace()).pricePlace(tap.getPricePlace()).idCar(tap.getIdCar()).idPlace(tap.getIdPlace()).build();
    }
    public TimeAndPriceDto from(TimeAndPrice timeAndPrice){
        return TimeAndPriceDto.builder().id(timeAndPrice.getId()).timePlace(timeAndPrice.getTimePlace()).pricePlace(timeAndPrice.getPricePlace()).idCar(timeAndPrice.getIdCar()).idPlace(timeAndPrice.getIdPlace()).build();
    }
}
