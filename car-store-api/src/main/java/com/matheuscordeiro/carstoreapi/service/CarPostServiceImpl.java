package com.matheuscordeiro.carstoreapi.service;

import com.matheuscordeiro.carstoreapi.dto.CarPostDto;
import com.matheuscordeiro.carstoreapi.entity.CarPost;
import com.matheuscordeiro.carstoreapi.repository.CarPostRepository;
import com.matheuscordeiro.carstoreapi.repository.OwnerPostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements  CarPostService {

    private final CarPostRepository carPostRepository;
    private final OwnerPostRepository ownerPostRepository;

    public CarPostServiceImpl(CarPostRepository carPostRepository,
                              OwnerPostRepository ownerPostRepository) {
        this.carPostRepository = carPostRepository;
        this.ownerPostRepository = ownerPostRepository;
    }

    @Override
    public void newPostDetails(CarPostDto carPostDto) {
        final var carPost = mapCarDtoToEntity(carPostDto);
        carPostRepository.save(carPost);
    }

    @Override
    public List<CarPostDto> getCarSales() {
        final var carSalesList = new ArrayList<CarPostDto>();
        carPostRepository.findAll().forEach(carPost -> {
            carSalesList.add(mapCarEntityToDto(carPost));
        });
        return carSalesList;
    }

    @Override
    public void changeCarSale(CarPostDto carPostDto, Long id) {
        carPostRepository.findById(id).ifPresentOrElse(carPost -> {
            setCarPost(carPostDto, carPost);
            carPostRepository.save(carPost);
        }, () -> {
                throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long id) {
        carPostRepository.deleteById(id);
    }

    private CarPostDto mapCarEntityToDto(CarPost carPost) {
        return CarPostDto.builder()
                .brand(carPost.getBrand())
                .model(carPost.getModel())
                .city(carPost.getCity())
                .description(carPost.getDescription())
                .engineVersion(carPost.getEngineVersion())
                .ownerName(carPost.getOwnerPost().getName())
                .createdDate(carPost.getCreatedDate().toString())
                .price(carPost.getPrice())
                .build();

    }

    private CarPost mapCarDtoToEntity(CarPostDto carPostDto) {
        final var carPost = new CarPost();
        ownerPostRepository.findById(carPostDto.ownerId()).ifPresentOrElse(ownerPost -> {
            carPost.setOwnerPost(ownerPost);
            carPost.setContact(ownerPost.getContact());
        }, () -> {
            throw new RuntimeException();
        });

        setCarPost(carPostDto, carPost);
        return carPost;
    }

    private static void setCarPost(CarPostDto carPostDto, CarPost carPost) {
        carPost.setBrand(carPostDto.brand());
        carPost.setDescription(carPostDto.description());
        carPost.setContact(carPost.getContact());
        carPost.setPrice(carPostDto.price());
        carPost.setEngineVersion(carPostDto.engineVersion());
        carPost.setModel(carPostDto.model());
    }
}
