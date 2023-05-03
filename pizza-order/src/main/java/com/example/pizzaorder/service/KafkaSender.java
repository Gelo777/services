package com.example.pizzaorder.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {

    private final KafkaTemplate<Integer, Integer> kafkaTemplate;

    public KafkaSender(KafkaTemplate<Integer, Integer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCustomMessage(Integer order) {
        kafkaTemplate.send("topic-1", order);
    }
}