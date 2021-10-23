package com.example.parking.Service.impl;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.TimeAndPrice;
import com.example.parking.Mapper.TimeAndPriceMapper;
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
    @Override
    public TimeAndPriceDto create(TimeAndPriceDto timeAndPriceDto) {
        TimeAndPrice timeAndPrice = timeAndPriceMapper.to(timeAndPriceDto);
        timeAndPriceRepository.save(timeAndPrice);
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public List<TimeAndPrice> readAll() {
        return timeAndPriceRepository.findAll();
    }

    @Override
    public TimeAndPriceDto read(Long id) throws Exception {
        TimeAndPrice timeAndPrice = timeAndPriceRepository.findById(id).orElseThrow(() -> new Exception("Запись отсутствует"));
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public TimeAndPriceDto update(TimeAndPriceDto timeAndPriceDto, Long id) throws Exception {
        TimeAndPrice timeAndPrice = timeAndPriceRepository.findById(id).orElseThrow(() -> new Exception("Запись отсутствует"));
        timeAndPrice.setTimePlace(timeAndPriceDto.getTimePlace());
        timeAndPrice.setPricePlace(timeAndPriceDto.getPricePlace());
        timeAndPrice.setIdCar(timeAndPriceDto.getIdCar());
        timeAndPrice.setIdPlace(timeAndPriceDto.getIdPlace());
        timeAndPriceRepository.save(timeAndPrice);
        return timeAndPriceMapper.from(timeAndPrice);
    }

    @Override
    public void delete(Long id) throws Exception {
        TimeAndPrice timeAndPrice = timeAndPriceRepository.findById(id).orElseThrow(() -> new Exception("Запись отсутствует"));
        timeAndPriceRepository.delete(timeAndPrice);
    }
}
