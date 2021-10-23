package com.example.parking.Controller;

import com.example.parking.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService carService;
}
