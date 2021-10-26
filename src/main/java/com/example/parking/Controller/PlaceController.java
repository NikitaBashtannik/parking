package com.example.parking.Controller;

import com.example.parking.Dto.PlaceDto;
import com.example.parking.Entity.Place;
import com.example.parking.Service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/{id}")
    public PlaceDto read(@PathVariable("id") Long id) throws Exception {
        log.info("Get place by id [{}]", id);
        return placeService.read(id);
    }

    @PostMapping("/")
    public PlaceDto create(@Valid @RequestBody PlaceDto placeDto) {
        log.info("Add new place with request [{}]", placeDto);
        return placeService.create(placeDto);
    }

    @PutMapping("/{id}")
    public PlaceDto update(@Valid @RequestBody PlaceDto placeDto, @PathVariable("id") Long id) throws Exception {
        log.info("Update place with request [{}] by id[{}]", placeDto, id);
        return placeService.update(placeDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        log.info("Delete place by id [{}]", id);
        placeService.delete(id);
    }

    @GetMapping("/")
    public List<Place> readAll(){
        log.info("Read all places in database");
        return placeService.readAll();
    }
}
