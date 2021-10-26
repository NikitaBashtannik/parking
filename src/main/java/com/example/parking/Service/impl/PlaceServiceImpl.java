package com.example.parking.Service.impl;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;
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
    public PlaceDto read(Long id) throws Exception {
        Place place = placeRepository.findById(id).orElseThrow(() -> new Exception("Место отсутствует"));
        return placeMapper.from(place);
    }

    @Override
    public PlaceDto update(PlaceDto placeDto, Long id) throws Exception {
        Place place = placeRepository.findById(id).orElseThrow(() -> new Exception("Место отсутствует"));
        place.setNumberPlace(placeDto.getNumberPlace());
        place.setAction(placeDto.getAction());
        placeRepository.save(place);
        return placeMapper.from(place);
    }

    @Override
    public void delete(Long id) throws Exception {
        Place place = placeRepository.findById(id).orElseThrow(() -> new Exception("Место отсутствует"));
        placeRepository.delete(place);
    }
}
