package com.matheuscordeiro.carsanalytics.repository;

import com.matheuscordeiro.carsanalytics.entity.CarModelAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalytics, Long> {
    Optional<CarModelAnalytics> findByModel(String model);
}