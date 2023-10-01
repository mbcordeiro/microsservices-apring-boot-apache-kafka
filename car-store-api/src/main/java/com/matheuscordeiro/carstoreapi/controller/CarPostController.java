package com.matheuscordeiro.carstoreapi.controller;

import com.matheuscordeiro.carstoreapi.dto.CarPostDto;
import com.matheuscordeiro.carstoreapi.service.CarPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sales/cars")
public class CarPostController {
    private final CarPostService carPostService;

    public CarPostController(CarPostService carPostService) {
        this.carPostService = carPostService;
    }

    @GetMapping
    public ResponseEntity<List<CarPostDto>> getCarSales() {
        return ResponseEntity.ok(carPostService.getCarSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarSales(@RequestBody CarPostDto carPostDto, @PathVariable("id") Long id) {
        carPostService.changeCarSale(carPostDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarSale(@PathVariable("id") Long id) {
        carPostService.removeCarSale(id);
        return ResponseEntity.noContent().build();
    }
}
