package com.example.pizzaorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {

    private Integer type;

    private Integer ingredients;
}
