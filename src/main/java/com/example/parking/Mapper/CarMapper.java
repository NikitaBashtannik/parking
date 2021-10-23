package com.example.parking.Mapper;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;

public class CarMapper {
    public Car to(CarDto carDto){
        return Car.builder().nameCar(carDto.getNameCar()).numberCar(carDto.getNumberCar()).build();
    }
    public CarDto from(Car car){
        return CarDto.builder().id(car.getId()).nameCar(car.getNameCar()).numberCar(car.getNumberCar()).build();
    }
}
