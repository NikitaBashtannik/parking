package com.example.parking.Service;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;

import java.util.List;

public interface PlaceService {
    PlaceDto create(PlaceDto placeDto);

    List<Place> readAll();

    PlaceDto read(Long id) throws Exception;

    PlaceDto update(PlaceDto placeDto, Long id) throws Exception;

    void delete(Long id) throws Exception;
}
