package com.example.parking;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Exception.ParkingException;
import com.example.parking.Mapper.PlaceMapper;
import com.example.parking.Repository.PlaceRepository;
import com.example.parking.Service.PlaceService;
import com.example.parking.Service.impl.PlaceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlaceServiceTest {

    private PlaceService placeService;

    private final PlaceRepository placeRepository = Mockito.mock(PlaceRepository.class);
    private final PlaceMapper placeMapper = new PlaceMapper();
    private final Place place = Place.builder()
            .id(1L)
            .number("12")
            .action("empty")
            .build();

    private final PlaceDto placeDto = PlaceDto.builder()
            .id(1L)
            .number("12")
            .action("empty")
            .build();


    @BeforeEach
    void setUp() {
        placeService = new PlaceServiceImpl(placeMapper, placeRepository);
    }

    @Test
    void get_success() throws ParkingException {
        when(placeRepository.findById(1L)).thenReturn(Optional.of(place));

        PlaceDto resultDto = placeService.read(1L);

        assertEquals(placeDto, resultDto);
        verify(placeRepository).findById(1L);
    }

    @Test
    void get_error() {
        when(placeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ParkingException.class, () -> placeService.read(1L));
    }

    @Test
    void add_success() {
        when(placeRepository.save(place)).thenReturn(place);

        PlaceDto resultDto = placeService.create(placeDto);
        assertEquals(placeDto, resultDto);
        verify(placeRepository).save(place);
    }

    @Test
    void update_success() throws ParkingException {
        when(placeRepository.findById(1L)).thenReturn(Optional.of(place));
        when(placeRepository.save(place)).thenReturn(place);

        PlaceDto resultDto = placeService.update(placeDto, 1L);
        assertEquals(resultDto, placeDto);
    }

    @Test
    void delete_success() throws ParkingException {
        when(placeRepository.findById(1L)).thenReturn(Optional.of(place));

        placeService.delete(1L);
        verify(placeRepository).findById(1L);
        verify(placeRepository).delete(place);
    }
}
