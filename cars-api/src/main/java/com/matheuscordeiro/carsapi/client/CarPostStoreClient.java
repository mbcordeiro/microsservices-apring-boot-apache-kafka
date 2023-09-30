package com.matheuscordeiro.carsapi.client;

import com.matheuscordeiro.carsapi.dto.CarPostDto;
import com.matheuscordeiro.carsapi.dto.OwnerPostDto;

import java.util.List;

public interface CarPostStoreClient {
    List<CarPostDto> carForSale();

    void ownerPostClient(final OwnerPostDto ownerPostDto);

    void changeCarForSale(final CarPostDto carPostDto, String id);

    void deleteCarForSale(final String id);
}
