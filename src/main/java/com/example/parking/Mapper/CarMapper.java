package com.example.parking.Mapper;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public Car to(CarDto carDto) {
        return Car.builder()
                .name(carDto.getName())
                .number(carDto.getNumber())
                .build();
    }

    public CarDto from(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .name(car.getName())
                .number(car.getNumber())
                .build();
    }
}
