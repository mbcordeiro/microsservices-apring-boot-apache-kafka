package com.matheuscordeiro.carstoreapi.message;

import com.matheuscordeiro.carstoreapi.dto.CarPostDto;
import com.matheuscordeiro.carstoreapi.service.CarPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerMessage {
    private final CarPostService carPostService;

    public KafkaConsumerMessage(CarPostService carPostService) {
        this.carPostService = carPostService;
    }

    @KafkaListener(topics = "car-post-topic", groupId = "store-post-group")
    public void listener(CarPostDto carPostDto) {
        log.info("CAR STORE - Received Car Post Information: {}", carPostDto);
        carPostService.newPostDetails(carPostDto);
    }
}
