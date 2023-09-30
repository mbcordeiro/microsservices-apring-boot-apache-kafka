package com.matheuscordeiro.carsapi.service;

import com.matheuscordeiro.carsapi.client.CarPostStoreClient;
import com.matheuscordeiro.carsapi.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {
    private final CarPostStoreClient carPostStoreClient;

    public OwnerPostServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public void createOwnerCar(OwnerPostDto ownerPostDto) {
        carPostStoreClient.ownerPostClient(ownerPostDto);
    }
}
