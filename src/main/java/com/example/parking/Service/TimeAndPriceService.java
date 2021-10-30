package com.example.parking.Service;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.TimeAndPrice;
import com.example.parking.Exception.ProjectException;

import java.util.List;

public interface TimeAndPriceService {
    TimeAndPriceDto create(TimeAndPriceDto timeAndPriceDto) throws ProjectException;

    List<TimeAndPrice> readAll();

    TimeAndPriceDto read(Long id) throws ProjectException;

    TimeAndPriceDto update(TimeAndPriceDto timeAndPriceDto, Long id) throws ProjectException;

    void delete(Long id) throws ProjectException;
}
