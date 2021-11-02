package com.example.parking;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;
import com.example.parking.Exception.ParkingException;
import com.example.parking.Mapper.CarMapper;
import com.example.parking.Repository.CarRepository;
import com.example.parking.Service.CarService;
import com.example.parking.Service.impl.CarServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarServiceTest {

    private CarService carService;

    private final CarRepository carRepository = Mockito.mock(CarRepository.class);
    private final CarMapper carMapper = new CarMapper();
    private final Car car = Car.builder()
            .id(1L)
            .name("BMW")
            .number("В123ВА55")
            .build();

    private final CarDto carDto = CarDto.builder()
            .id(1L)
            .name("BMW")
            .number("В123ВА55")
            .build();

    @BeforeEach
    void setUp() {
        carService = new CarServiceImpl(carRepository, carMapper);
    }

    @Test
    void get_success() throws ParkingException {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        CarDto resultDto = carService.read(1L);

        assertEquals(carDto, resultDto);
        verify(carRepository).findById(1L);
    }

    @Test
    void get_error() {
        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ParkingException.class, () -> carService.read(1L));
    }

    @Test
    void add_success() {
        when(carRepository.save(car)).thenReturn(car);

        CarDto resultDto = carService.create(carDto);
        assertEquals(carDto, resultDto);
        verify(carRepository).save(car);
    }

    @Test
    void update_success() throws ParkingException {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carRepository.save(car)).thenReturn(car);

        CarDto resultDto = carService.update(carDto, 1L);
        assertEquals(resultDto, carDto);
    }

    @Test
    void delete_success() throws ParkingException {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        carService.delete(1L);
        verify(carRepository).findById(1L);
        verify(carRepository).delete(car);
    }
}
