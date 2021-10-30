package com.example.parking.Service;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;
import com.example.parking.Exception.ProjectException;

import java.util.List;

public interface CarService {
    CarDto create(CarDto carDto);

    List<Car> readAll();

    CarDto read(Long id) throws ProjectException;

    CarDto update(CarDto carDto, Long id) throws ProjectException;

    void delete(Long id) throws ProjectException;

}
