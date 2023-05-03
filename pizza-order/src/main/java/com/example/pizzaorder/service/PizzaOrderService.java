package com.example.pizzaorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("kitchen-service")
@Component
public interface PizzaOrderService {

    @PostMapping("/kitchen")
    void preparePizza(@RequestBody String number);
}
