package com.example.pizzaorder.service;

import com.example.pizzaorder.model.ErrorDto;
import com.example.pizzaorder.model.PizzaDto;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<Integer, PizzaDto> kafkaTemplate;

    private final KafkaTemplate<Integer, ErrorDto> kafkaErrorTemplate;

    public void sendCustomMessage(PizzaDto order) {
        kafkaTemplate.send("topic-1", order);
    }
    public void sendErrorMessage(ErrorDto order) {
        kafkaErrorTemplate.send("topic-1", order);
    }

 //   @PostConstruct
    public void init(){

        PizzaDto pizzaDto = new PizzaDto("margarita", List.of("сыр", "помидоры"));
        ErrorDto errorDto = new ErrorDto(1,2);
        sendCustomMessage(pizzaDto);
        sendErrorMessage(errorDto);
    }

}
