package com.example.parking.Controller;

import com.example.parking.Service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlaceController {
    private final PlaceService placeService;
}
