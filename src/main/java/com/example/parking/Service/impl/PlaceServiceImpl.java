package com.example.parking.Service.impl;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Exception.ParkingException;
import com.example.parking.Mapper.PlaceMapper;
import com.example.parking.Repository.PlaceRepository;
import com.example.parking.Service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceMapper placeMapper;
    private final PlaceRepository placeRepository;

    @Override
    public PlaceDto create(PlaceDto placeDto) {
        Place place = placeMapper.to(placeDto);
        placeRepository.save(place);
        return placeMapper.from(place);
    }

    @Override
    public List<Place> readAll() {
        return placeRepository.findAll();
    }

    @Override
    public PlaceDto read(Long id) throws ParkingException {
        return placeMapper.from(getById(id));
    }

    @Override
    public PlaceDto update(PlaceDto placeDto, Long id) throws ParkingException {
        Place place = getById(id);
        place.setNumber(placeDto.getNumber());
        place.setAction(placeDto.getAction());
        placeRepository.save(place);
        return placeMapper.from(place);
    }

    @Override
    public void delete(Long id) throws ParkingException {
        placeRepository.delete(getById(id));
    }

    public Place getById(Long id) throws ParkingException {
        return placeRepository.findById(id).orElseThrow(() -> new ParkingException("required.value.error"));
    }
}
