package com.example.parking.Controller;

import com.example.parking.Dto.CarDto;
import com.example.parking.Entity.Car;
import com.example.parking.Exception.ParkingException;
import com.example.parking.Service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping("/{id}")
    public CarDto read(@PathVariable("id") Long id) throws ParkingException {
        log.info("Get car by id [{}]", id);
        return carService.read(id);
    }

    @PostMapping("/")
    public CarDto create(@Valid @RequestBody CarDto carDto) {
        log.info("Add new car with request [{}]", carDto);
        return carService.create(carDto);
    }

    @PutMapping("/{id}")
    public CarDto update(@Valid @RequestBody CarDto carDto, @PathVariable("id") Long id) throws ParkingException {
        log.info("Update car with request [{}] by id[{}]", carDto, id);
        return carService.update(carDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws ParkingException {
        log.info("Delete car by id [{}]", id);
        carService.delete(id);
    }

    @GetMapping("/")
    public List<Car> readAll() {
        log.info("Read all cars in database");
        return carService.readAll();
    }
}