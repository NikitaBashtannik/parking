package com.example.parking;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.Car;
import com.example.parking.Entity.Place;
import com.example.parking.Entity.TimeAndPrice;
import com.example.parking.Exception.ParkingException;
import com.example.parking.Mapper.TimeAndPriceMapper;
import com.example.parking.Repository.CarRepository;
import com.example.parking.Repository.PlaceRepository;
import com.example.parking.Repository.TimeAndPriceRepository;
import com.example.parking.Service.TimeAndPriceService;
import com.example.parking.Service.impl.TimeAndPriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TimeAndPriceServiceTest {
    private TimeAndPriceService timeAndPriceService;

    private final CarRepository carRepository = Mockito.mock(CarRepository.class);
    private final PlaceRepository placeRepository = Mockito.mock(PlaceRepository.class);
    private final TimeAndPriceRepository timeAndPriceRepository = Mockito.mock(TimeAndPriceRepository.class);
    private final TimeAndPriceMapper timeAndPriceMapper = new TimeAndPriceMapper();
    private final Car car = Car.builder()
            .id(1L)
            .name("BMW")
            .number("В123ВА55")
            .build();
    private final Place place = Place.builder()
            .id(1L)
            .number("12")
            .action("empty")
            .build();
    private final TimeAndPrice timeAndPrice = TimeAndPrice.builder()
            .id(1L)
            .price("500R")
            .time("14-00")
            .build();

    private final TimeAndPriceDto timeAndPriceDto = TimeAndPriceDto.builder()
            .id(1L)
            .price("500R")
            .time("14-00")
            .idCar(car.getId())
            .idPlace(place.getId())
            .build();


    @BeforeEach
    void setUp() {
        carRepository.save(car);
        placeRepository.save(place);
        timeAndPrice.setCar(car);
        timeAndPrice.setPlace(place);
        timeAndPriceService = new TimeAndPriceServiceImpl(timeAndPriceRepository, timeAndPriceMapper, carRepository, placeRepository);
    }

    @Test
    void get_success() throws ParkingException {
        when(timeAndPriceRepository.findById(1L)).thenReturn(Optional.of(timeAndPrice));

        TimeAndPriceDto resultDto = timeAndPriceService.read(1L);

        assertEquals(timeAndPriceDto, resultDto);
        verify(timeAndPriceRepository).findById(1L);
    }

    @Test
    void get_error() {
        when(timeAndPriceRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ParkingException.class, () -> timeAndPriceService.read(1L));
    }

    @Test
    void add_success() throws ParkingException {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(placeRepository.findById(1L)).thenReturn(Optional.of(place));
        when(timeAndPriceRepository.save(timeAndPrice)).thenReturn(timeAndPrice);

        TimeAndPriceDto resultDto = timeAndPriceService.create(timeAndPriceDto);
        assertEquals(timeAndPriceDto, resultDto);
        verify(timeAndPriceRepository).save(timeAndPrice);
    }

    @Test
    void update_success() throws ParkingException {
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(placeRepository.findById(1L)).thenReturn(Optional.of(place));
        when(timeAndPriceRepository.findById(1L)).thenReturn(Optional.of(timeAndPrice));
        when(timeAndPriceRepository.save(timeAndPrice)).thenReturn(timeAndPrice);

        TimeAndPriceDto resultDto = timeAndPriceService.update(timeAndPriceDto, 1L);
        assertEquals(resultDto, timeAndPriceDto);
    }

    @Test
    void delete_success() throws ParkingException {
        when(timeAndPriceRepository.findById(1L)).thenReturn(Optional.of(timeAndPrice));

        timeAndPriceService.delete(1L);
        verify(timeAndPriceRepository).findById(1L);
        verify(timeAndPriceRepository).delete(timeAndPrice);
    }
}
