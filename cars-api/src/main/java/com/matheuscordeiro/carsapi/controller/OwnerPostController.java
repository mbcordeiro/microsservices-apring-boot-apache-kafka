package com.matheuscordeiro.carsapi.controller;

import com.matheuscordeiro.carsapi.dto.OwnerPostDto;
import com.matheuscordeiro.carsapi.service.OwnerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owners")
public class OwnerPostController {
    private final OwnerPostService ownerPostService;

    public OwnerPostController(OwnerPostService ownerPostService) {
        this.ownerPostService = ownerPostService;
    }

    @PostMapping
    public ResponseEntity<Void> createOwnerCar(@RequestBody OwnerPostDto ownerPostDto) {
        ownerPostService.createOwnerCar(ownerPostDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
