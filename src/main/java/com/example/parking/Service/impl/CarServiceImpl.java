package com.example.parking.Service.impl;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;
import com.example.parking.Exception.ParkingException;
import com.example.parking.Mapper.CarMapper;
import com.example.parking.Repository.CarRepository;
import com.example.parking.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto create(CarDto carDto) {
        Car car = carMapper.to(carDto);
        carRepository.save(car);
        return carMapper.from(car);
    }

    @Override
    public List<Car> readAll() {
        return carRepository.findAll();
    }

    @Override
    public CarDto read(Long id) throws ParkingException {
        return carMapper.from(getById(id));
    }

    @Transactional
    @Override
    public CarDto update(CarDto carDto, Long id) throws ParkingException {
        Car car = getById(id);
        car.setName(carDto.getName());
        car.setNumber(car.getNumber());
        carRepository.save(car);
        return carMapper.from(car);
    }

    @Transactional
    @Override
    public void delete(Long id) throws ParkingException {
        carRepository.delete(getById(id));
    }

    public Car getById(Long id) throws ParkingException {
        return carRepository.findById(id).orElseThrow(() -> new ParkingException("required.value.error"));
    }
}
