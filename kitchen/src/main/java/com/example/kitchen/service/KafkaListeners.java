package com.example.kitchen.service;

import com.example.kitchen.model.PizzaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaListeners {

    private final ErrorHandlingDeserializer<PizzaDto> errorHandlingDeserializer;
    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();
    private final KafkaTemplate<Integer, byte[]> kafkaTemplate;
    private final ConsumerFactory<Integer, byte[]> consumerFactory;

    @KafkaListener(topics = "topic-1")
    public void listener(ConsumerRecord<Integer, byte[]> order, Acknowledgment acknowledgment) throws InterruptedException {
        PizzaDto pizzaDto = deserializePizzaDto(order.value());
        if (pizzaDto == null) {
            kafkaTemplate.send("topic-1.DLT", order.key(), order.value());
        } else {
            cook(pizzaDto);
        }
        acknowledgment.acknowledge();
    }

    private PizzaDto deserializePizzaDto(byte[] value) {
        return errorHandlingDeserializer.deserialize(null, value);
    }

    private void cook(PizzaDto order) throws InterruptedException {
        System.out.println("Готовим заказ: " + order);
        Thread.sleep(5000); //имитация готовки заказа
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, byte[]> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, byte[]> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }

    @KafkaListener(topics = "topic-1.DLT")
    public void dltListen(byte[] in) {
        log.info("Received from DLT: " + new String(in, StandardCharsets.UTF_8));
        exec.execute(() -> System.out.println("Кривой объект..."));
    }
}
