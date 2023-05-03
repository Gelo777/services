package com.example.kitchen.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "topic-1",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listener(ConsumerRecord<Integer, Integer> order, Acknowledgment acknowledgment) throws InterruptedException {
        cook(order.value());
        acknowledgment.acknowledge();
    }

    public void cook(Integer order) throws InterruptedException {
        System.out.println("Готовим заказ: " + order);
        Thread.sleep(5000); //имитация готовки заказа
    }
}
