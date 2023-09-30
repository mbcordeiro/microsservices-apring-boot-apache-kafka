package com.matheuscordeiro.carsapi.client;

import com.matheuscordeiro.carsapi.dto.CarPostDto;
import com.matheuscordeiro.carsapi.dto.OwnerPostDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClientImpl implements CarPostStoreClient{
    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales";

    private final RestTemplate restTemplate;

    public CarPostStoreClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CarPostDto> carForSale(){
        final var responseEntity = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI+"/cars", CarPostDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public void ownerPostClient(final OwnerPostDto ownerPostDto) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, ownerPostDto, OwnerPostDto.class);
    }

    @Override
    public void changeCarForSale(final CarPostDto carPostDto, String id) {
        restTemplate.put(USER_STORE_SERVICE_URI+"/cars/"+id, carPostDto, CarPostDto.class);
    }

    @Override
    public void deleteCarForSale(final String id) {
        restTemplate.delete(POSTS_STORE_SERVICE_URI+"/cars/"+id);
    }
}
