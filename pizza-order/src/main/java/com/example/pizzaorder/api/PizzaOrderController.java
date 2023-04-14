package com.example.pizzaorder.api;

import com.example.pizzaorder.service.PizzaOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza-order")
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @PostMapping
    public ResponseEntity<Void> cook(@RequestBody String number){
        pizzaOrderService.preparePizza(number);
        return ResponseEntity.ok().build();
    }
}
