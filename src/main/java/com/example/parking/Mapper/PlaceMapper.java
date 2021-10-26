package com.example.parking.Mapper;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {
    public Place to(PlaceDto placeDto) {
        return Place.builder()
                .numberPlace(placeDto.getNumberPlace())
                .action(placeDto.getAction())
                .build();
    }

    public PlaceDto from(Place place) {
        return PlaceDto.builder()
                .id(place.getId())
                .numberPlace(place.getNumberPlace())
                .action(place.getAction())
                .build();
    }
}
