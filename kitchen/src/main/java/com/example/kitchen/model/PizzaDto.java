package com.example.kitchen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDto {
    @NonNull
    private String type;
    @NonNull
    private List<String> ingredients;
}
