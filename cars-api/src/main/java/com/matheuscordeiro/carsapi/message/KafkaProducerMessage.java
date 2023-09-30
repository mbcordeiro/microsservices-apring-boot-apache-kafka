package com.matheuscordeiro.carsapi.message;

import com.matheuscordeiro.carsapi.dto.CarPostDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {
    private final KafkaTemplate<String, CarPostDto> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    public KafkaProducerMessage(KafkaTemplate<String, CarPostDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CarPostDto carPostDto) {
        kafkaTemplate.send(KAFKA_TOPIC, carPostDto);
    }
}
