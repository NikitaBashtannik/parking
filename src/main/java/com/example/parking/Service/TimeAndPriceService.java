package com.example.parking.Service;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.TimeAndPrice;
import com.example.parking.Exception.ParkingException;

import java.util.List;

public interface TimeAndPriceService {
    TimeAndPriceDto create(TimeAndPriceDto timeAndPriceDto) throws ParkingException;

    List<TimeAndPrice> readAll();

    TimeAndPriceDto read(Long id) throws ParkingException;

    TimeAndPriceDto update(TimeAndPriceDto timeAndPriceDto, Long id) throws ParkingException;

    void delete(Long id) throws ParkingException;
}
