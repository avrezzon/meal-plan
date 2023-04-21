package com.avrezzon.mealplan.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serving implements Serializable {
    private Double servingQty;
    private FoodType type;

}
