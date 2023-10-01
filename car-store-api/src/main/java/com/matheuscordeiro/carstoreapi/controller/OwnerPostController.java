package com.matheuscordeiro.carstoreapi.controller;

import com.matheuscordeiro.carstoreapi.dto.OwnerPostDto;
import com.matheuscordeiro.carstoreapi.service.OwnerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class OwnerPostController {
    private final OwnerPostService ownerPostService;

    public OwnerPostController(OwnerPostService ownerPostService) {
        this.ownerPostService = ownerPostService;
    }

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody OwnerPostDto ownerPostDto) {
        ownerPostService.createOwnerPost(ownerPostDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
