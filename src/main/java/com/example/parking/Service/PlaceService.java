package com.example.parking.Service;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Exception.ParkingException;

import java.util.List;

public interface PlaceService {
    PlaceDto create(PlaceDto placeDto);

    List<Place> readAll();

    PlaceDto read(Long id) throws ParkingException;

    PlaceDto update(PlaceDto placeDto, Long id) throws ParkingException;

    void delete(Long id) throws ParkingException;
}
