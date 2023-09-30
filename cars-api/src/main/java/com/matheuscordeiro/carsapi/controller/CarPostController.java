package com.matheuscordeiro.carsapi.controller;

import com.matheuscordeiro.carsapi.dto.CarPostDto;
import com.matheuscordeiro.carsapi.service.CarPostStoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarPostController {
    private final CarPostStoreService carPostStoreService;

    public CarPostController(CarPostStoreService carPostStoreService) {
        this.carPostStoreService = carPostStoreService;
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
