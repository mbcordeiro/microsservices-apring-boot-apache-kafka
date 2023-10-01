package com.matheuscordeiro.carsanalytics.service;

import com.matheuscordeiro.carsanalytics.dto.CarPostDto;

public interface PostAnalyticsService {
    void saveDataAnalytics(CarPostDto carPostDto);
}
