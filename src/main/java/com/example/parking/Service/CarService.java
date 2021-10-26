package com.example.parking.Service;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;

import java.util.List;

public interface CarService {
    CarDto create(CarDto carDto);

    List<Car> readAll();

    CarDto read(Long id) throws Exception;

    CarDto update(CarDto carDto, Long id) throws Exception;

    void delete(Long id) throws Exception;

}
