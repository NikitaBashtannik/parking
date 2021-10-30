package com.example.parking.Service.impl;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.TimeAndPrice;
import com.example.parking.Exception.ProjectException;
import com.example.parking.Mapper.TimeAndPriceMapper;
import com.example.parking.Repository.CarRepository;
import com.example.parking.Repository.PlaceRepository;
import com.example.parking.Repository.TimeAndPriceRepository;
import com.example.parking.Service.TimeAndPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimeAndPriceServiceImpl implements TimeAndPriceService {
    private final TimeAndPriceRepository timeAndPriceRepository;
    private final TimeAndPriceMapper timeAndPriceMapper;
    private final CarRepository carRepository;
    private final PlaceRepository placeRepository;

    @Override
    public TimeAndPriceDto create(TimeAndPriceDto timeAndPriceDto) throws ProjectException {
        TimeAndPrice timeAndPrice = timeAndPriceMapper.to(timeAndPriceDto);
        timeAndPrice.setCar(carRepository.findById(timeAndPriceDto.getIdCar()).orElseThrow(() -> new ProjectException("Машина отсутствует")));
        timeAndPrice.setPlace(placeRepository.findById(timeAndPriceDto.getIdCar()).orElseThrow(() -> new ProjectException("Место отсутствует")));
        timeAndPriceRepository.save(timeAndPrice);
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public List<TimeAndPrice> readAll() {
        return timeAndPriceRepository.findAll();
    }

    @Override
    public TimeAndPriceDto read(Long id) throws ProjectException {
        TimeAndPrice timeAndPrice = timeAndPriceRepository.findById(id).orElseThrow(() -> new ProjectException("Запись отсутствует"));
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public TimeAndPriceDto update(TimeAndPriceDto timeAndPriceDto, Long id) throws ProjectException {
        TimeAndPrice timeAndPrice = timeAndPriceRepository.findById(id).orElseThrow(() -> new ProjectException("Запись отсутствует"));
        timeAndPrice.setTimePlace(timeAndPriceDto.getTimePlace());
        timeAndPrice.setPricePlace(timeAndPriceDto.getPricePlace());
        timeAndPrice.setCar(carRepository.findById(timeAndPriceDto.getIdCar()).orElseThrow(() -> new ProjectException("Машина отсутствует")));
        timeAndPrice.setPlace(placeRepository.findById(timeAndPriceDto.getIdCar()).orElseThrow(() -> new ProjectException("Место отсутствует")));
        timeAndPriceRepository.save(timeAndPrice);
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public void delete(Long id) throws ProjectException {
        TimeAndPrice timeAndPrice = timeAndPriceRepository.findById(id).orElseThrow(() -> new ProjectException("Запись отсутствует"));
        timeAndPriceRepository.delete(timeAndPrice);
    }
}
