package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Serving implements Serializable {
    private Double servingQty;
    private FoodType type;
}
