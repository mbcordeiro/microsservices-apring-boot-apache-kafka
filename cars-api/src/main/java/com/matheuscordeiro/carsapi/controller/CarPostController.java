package com.matheuscordeiro.carsapi.controller;

import com.matheuscordeiro.carsapi.dto.CarPostDto;
import com.matheuscordeiro.carsapi.message.KafkaProducerMessage;
import com.matheuscordeiro.carsapi.service.CarPostStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@Slf4j
public class CarPostController {
    private final CarPostStoreService carPostStoreService;

    private final KafkaProducerMessage kafkaProducerMessage;

    public CarPostController(CarPostStoreService carPostStoreService, KafkaProducerMessage kafkaProducerMessage) {
        this.carPostStoreService = carPostStoreService;
        this.kafkaProducerMessage = kafkaProducerMessage;
    }

    @PostMapping("/post")
    public ResponseEntity<Void> postCarForSale(@RequestBody CarPostDto carPostDto) {
        log.info("CARS API - Producer Car Post information: {}", carPostDto);
        kafkaProducerMessage.sendMessage(carPostDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/posts}")
    public ResponseEntity<List<CarPostDto>> getCarSales() {
        return ResponseEntity.ok().body(carPostStoreService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarSale(@RequestBody CarPostDto carPostDto, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSale(carPostDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarForSale(@PathVariable("id") String id) {
        carPostStoreService.removeCarForSale(id);
        return ResponseEntity.noContent().build();
    }
}
