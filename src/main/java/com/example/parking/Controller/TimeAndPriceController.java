package com.example.parking.Controller;

import com.example.parking.Service.TimeAndPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TimeAndPriceController {
    private final TimeAndPriceService timeAndPriceService;
}
