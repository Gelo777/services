package com.example.kitchen.api;

import com.example.kitchen.service.KafkaListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class KitchenController {

    @Value("${ready-to-order}")
    private String exampleProperty;

    @Autowired
    private KafkaListeners kafkaListeners;

    @PostMapping("/kitchen")
    public ResponseEntity<Void> preparePizza(@RequestBody String pizzaOrder) {
        System.out.println("Готовим пиццу: " + exampleProperty);
        // здесь должна быть логика по приготовлению пиццы
        return ResponseEntity.ok().build();
    }
//    @GetMapping("/test")
//    public ResponseEntity<Void> test() {
//        kafkaListeners.test();
//        return ResponseEntity.ok().build();
//    }
}
