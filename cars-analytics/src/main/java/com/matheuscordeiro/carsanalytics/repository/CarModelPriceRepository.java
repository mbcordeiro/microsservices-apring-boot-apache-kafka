package com.matheuscordeiro.carsanalytics.repository;

import com.matheuscordeiro.carsanalytics.entity.CarModelPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelPriceRepository extends JpaRepository<CarModelPrice, Long> {
}