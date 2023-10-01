package com.matheuscordeiro.carsanalytics.service;

import com.matheuscordeiro.carsanalytics.dto.CarPostDto;
import com.matheuscordeiro.carsanalytics.entity.BrandAnalytics;
import com.matheuscordeiro.carsanalytics.entity.CarModelAnalytics;
import com.matheuscordeiro.carsanalytics.entity.CarPriceAnalytics;
import com.matheuscordeiro.carsanalytics.repository.BrandAnalyticsRepository;
import com.matheuscordeiro.carsanalytics.repository.CarModelAnalyticsRepository;
import com.matheuscordeiro.carsanalytics.repository.CarPriceAnalyticsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {
    private final BrandAnalyticsRepository brandAnalyticsRepository;

    private final CarModelAnalyticsRepository carModelAnalyticsRepository;

    private final CarPriceAnalyticsRepository carPriceAnalyticsRepository;

    public PostAnalyticsServiceImpl(BrandAnalyticsRepository brandAnalyticsRepository,
                                    CarModelAnalyticsRepository carModelAnalyticsRepository,
                                    CarPriceAnalyticsRepository carPriceAnalyticsRepository) {
        this.brandAnalyticsRepository = brandAnalyticsRepository;
        this.carModelAnalyticsRepository = carModelAnalyticsRepository;
        this.carPriceAnalyticsRepository = carPriceAnalyticsRepository;
    }

    @Override
    public void saveDataAnalytics(CarPostDto carPostDto) {
        saveBrandAnalytics(carPostDto.brand());
        saveCarModelAnalytics(carPostDto.model());
        saveCarModelPriceAnalytics(carPostDto.model(), carPostDto.price());
    }

    private void saveCarModelPriceAnalytics(String model, BigDecimal price) {
        final var carModelPrice = new CarPriceAnalytics();
        carModelPrice.setModel(model);
        carModelPrice.setPrice(price);
        carPriceAnalyticsRepository.save(carModelPrice);
    }

    private void saveCarModelAnalytics(String model) {
        final var carModelAnalytics = new CarModelAnalytics();
        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(m -> {
            m.setPosts(m.getPosts()+1);
            carModelAnalyticsRepository.save(m);
        }, () -> {
            carModelAnalytics.setModel(model);
            carModelAnalytics.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalytics);
        });
    }

    private void saveBrandAnalytics(String brand) {
        final var brandAnalytics = new BrandAnalytics();
        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(b -> {
            b.setPosts(b.getPosts()+1);
            brandAnalyticsRepository.save(b);
        }, () -> {
            brandAnalytics.setBrand(brand);
            brandAnalytics.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalytics);
        });
    }
}
