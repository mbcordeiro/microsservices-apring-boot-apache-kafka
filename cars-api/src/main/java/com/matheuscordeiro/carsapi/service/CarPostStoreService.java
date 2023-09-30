package com.matheuscordeiro.carsapi.service;

import com.matheuscordeiro.carsapi.dto.CarPostDto;

import java.util.List;

public interface CarPostStoreService {
    List<CarPostDto> getCarForSales();
    void changeCarForSale(CarPostDto carPostDto, String id);
    void removeCarForSale(String id);
}
