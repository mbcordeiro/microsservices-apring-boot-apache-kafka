package com.matheuscordeiro.carsanalytics.message;

import com.matheuscordeiro.carsanalytics.dto.CarPostDto;
import com.matheuscordeiro.carsanalytics.service.PostAnalyticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerMessage {
    private final PostAnalyticsService postAnalyticsService;

    public KafkaConsumerMessage(PostAnalyticsService postAnalyticsService) {
        this.postAnalyticsService = postAnalyticsService;
    }


    @KafkaListener(topics = "car-post-topic", groupId = "analytics-post-group")
    public void listener(@Payload CarPostDto carPostDto) {
        log.info("CAR ANALYTICS - Received Car Post Information: {}", carPostDto);
        postAnalyticsService.saveDataAnalytics(carPostDto);
    }
}