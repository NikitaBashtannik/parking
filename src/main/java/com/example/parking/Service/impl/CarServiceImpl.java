package com.example.parking.Service.impl;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;
import com.example.parking.Mapper.CarMapper;
import com.example.parking.Repository.CarRepository;
import com.example.parking.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public CarDto read(Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Exception("Машина отсутствует"));
        return carMapper.from(car);
    }

    @Override
    public CarDto update(CarDto carDto, Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Exception("Машина отсутствует"));
        car.setNameCar(carDto.getNameCar());
        car.setNumberCar(carDto.getNumberCar());
        carRepository.save(car);
        return carMapper.from(car);
    }

    @Override
    public void delete(Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Exception("Машина отсутствует"));
        carRepository.delete(car);
    }
}
