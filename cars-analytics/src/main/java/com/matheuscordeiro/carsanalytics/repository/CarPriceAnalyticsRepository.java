package com.matheuscordeiro.carsanalytics.repository;

import com.matheuscordeiro.carsanalytics.entity.CarPriceAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPriceAnalyticsRepository extends JpaRepository<CarPriceAnalytics, Long> {
}