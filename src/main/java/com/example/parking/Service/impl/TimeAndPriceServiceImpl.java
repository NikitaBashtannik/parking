package com.example.parking.Service.impl;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.TimeAndPrice;
import com.example.parking.Exception.ParkingException;
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
    public TimeAndPriceDto create(TimeAndPriceDto timeAndPriceDto) throws ParkingException {
        TimeAndPrice timeAndPrice = timeAndPriceMapper.to(timeAndPriceDto);
        setCarAndPlace(timeAndPrice, timeAndPriceDto);
        timeAndPriceRepository.save(timeAndPrice);
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public List<TimeAndPrice> readAll() {
        return timeAndPriceRepository.findAll();
    }

    @Override
    public TimeAndPriceDto read(Long id) throws ParkingException {
        return timeAndPriceMapper.from(getById(id));
    }

    @Override
    public TimeAndPriceDto update(TimeAndPriceDto timeAndPriceDto, Long id) throws ParkingException {
        TimeAndPrice timeAndPrice = getById(id);
        timeAndPrice.setTime(timeAndPriceDto.getTime());
        timeAndPrice.setPrice(timeAndPriceDto.getPrice());
        setCarAndPlace(timeAndPrice, timeAndPriceDto);
        timeAndPriceRepository.save(timeAndPrice);
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public void delete(Long id) throws ParkingException {
        timeAndPriceRepository.delete(getById(id));
    }

    public TimeAndPrice getById(Long id) throws ParkingException {
        return timeAndPriceRepository.findById(id).orElseThrow(() -> new ParkingException("required.value.error"));
    }

    public void setCarAndPlace(TimeAndPrice timeAndPrice, TimeAndPriceDto timeAndPriceDto) throws ParkingException {
        timeAndPrice.setCar(carRepository.findById(timeAndPriceDto.getIdCar()).orElseThrow(() -> new ParkingException("required.value.error")));
        timeAndPrice.setPlace(placeRepository.findById(timeAndPriceDto.getIdCar()).orElseThrow(() -> new ParkingException("required.value.error")));
    }
}
