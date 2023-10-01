package com.matheuscordeiro.carstoreapi.service;

import com.matheuscordeiro.carstoreapi.dto.CarPostDto;

import java.util.List;

public interface CarPostService {
    void newPostDetails(CarPostDto carPostDto);

    List<CarPostDto> getCarSales();

    void changeCarSale(CarPostDto carPostDto, Long id);

    void removeCarSale(Long id);
}
