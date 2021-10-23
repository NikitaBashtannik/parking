package com.example.parking.Service;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Entity.TimeAndPrice;

import java.util.List;

public interface TimeAndPriceService {
    TimeAndPriceDto create(TimeAndPriceDto timeAndPriceDto);

    List<TimeAndPrice> readAll();

    TimeAndPriceDto read(Long id) throws Exception;

    TimeAndPriceDto update(TimeAndPriceDto timeAndPriceDto,Long id) throws Exception;

    void delete(Long id) throws Exception;
}
