package com.matheuscordeiro.carsapi.service;

import com.matheuscordeiro.carsapi.client.CarPostStoreClient;
import com.matheuscordeiro.carsapi.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {
    private final CarPostStoreClient carPostStoreClient;

    public CarPostStoreServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public List<CarPostDto> getCarForSales() {
        return carPostStoreClient.carForSale();
    }

    @Override
    public void changeCarForSale(CarPostDto carPostDto, String id) {
        carPostStoreClient.changeCarForSale(carPostDto, id);
    }

    @Override
    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSale(id);
    }
}
