package com.example.kitchen.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class KitchenController {

    @Value("${ready-to-order}")
    private String exampleProperty;

    @PostMapping("/kitchen")
    public ResponseEntity<Void> preparePizza(@RequestBody String pizzaOrder) {
        System.out.println("Готовим пиццу: " + exampleProperty);
        // здесь должна быть логика по приготовлению пиццы
        return ResponseEntity.ok().build();
    }
}
