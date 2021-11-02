package com.example.parking.Service;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;
import com.example.parking.Exception.ParkingException;

import java.util.List;

public interface CarService {
    CarDto create(CarDto carDto);

    List<Car> readAll();

    CarDto read(Long id) throws ParkingException;

    CarDto update(CarDto carDto, Long id) throws ParkingException;

    void delete(Long id) throws ParkingException;

}
