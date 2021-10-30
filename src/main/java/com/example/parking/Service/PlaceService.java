package com.example.parking.Service;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Exception.ProjectException;

import java.util.List;

public interface PlaceService {
    PlaceDto create(PlaceDto placeDto);

    List<Place> readAll();

    PlaceDto read(Long id) throws ProjectException;

    PlaceDto update(PlaceDto placeDto, Long id) throws ProjectException;

    void delete(Long id) throws ProjectException;
}
