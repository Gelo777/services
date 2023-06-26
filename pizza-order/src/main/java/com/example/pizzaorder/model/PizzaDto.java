package com.example.pizzaorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PizzaDto {

    private String type;

    private List<String> ingredients;
}
