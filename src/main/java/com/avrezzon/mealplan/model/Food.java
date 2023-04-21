package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food implements Serializable {

    protected String name;
    protected Double servingSize;
    protected Measurement unitOfMeasure;
    protected FoodType type;

    public Food(FoodType type) {
        this.type = type;
    }
}
