package com.matheuscordeiro.carsanalytics.repository;

import com.matheuscordeiro.carsanalytics.entity.BrandAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandAnalyticsRepository extends JpaRepository<BrandAnalytics, Long> {
    Optional<BrandAnalytics> findByBrand(Long brand);
}
