package com.example.parking.Controller;

import com.example.parking.Dto.TimeAndPriceDto;
import com.example.parking.Entity.TimeAndPrice;
import com.example.parking.Exception.ProjectException;
import com.example.parking.Service.TimeAndPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/timeandprice")
public class TimeAndPriceController {
    private final TimeAndPriceService timeAndPriceService;

    @GetMapping("/{id}")
    public TimeAndPriceDto read(@PathVariable("id") Long id) throws ProjectException {
        log.info("Get contract by id [{}]", id);
        return timeAndPriceService.read(id);
    }

    @PostMapping("/")
    public TimeAndPriceDto create(@Valid @RequestBody TimeAndPriceDto timeAndPriceDto) throws ProjectException {
        log.info("Add new contract with request [{}]", timeAndPriceDto);
        return timeAndPriceService.create(timeAndPriceDto);
    }

    @PutMapping("/{id}")
    public TimeAndPriceDto update(@Valid @RequestBody TimeAndPriceDto timeAndPriceDto, @PathVariable("id") Long id) throws ProjectException {
        log.info("Update contract with request [{}] by id[{}]", timeAndPriceDto, id);
        return timeAndPriceService.update(timeAndPriceDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws ProjectException {
        log.info("Delete contract by id [{}]", id);
        timeAndPriceService.delete(id);
    }

    @GetMapping("/")
    public List<TimeAndPrice> readAll() {
        log.info("Read all places in database");
        return timeAndPriceService.readAll();
    }
}
