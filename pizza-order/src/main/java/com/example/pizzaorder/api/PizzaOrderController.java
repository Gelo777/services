package com.example.pizzaorder.api;

import com.example.pizzaorder.service.KafkaSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza-order")
public class PizzaOrderController {

    private final KafkaSender kafkaSender;

    public PizzaOrderController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @PostMapping
    public ResponseEntity<Void> cook(@RequestBody Integer number){
        kafkaSender.sendCustomMessage(number);
        return ResponseEntity.ok().build();
    }
}
