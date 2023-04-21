package com.avrezzon.mealplan.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServingGuideline extends Serving {
    private FoodType type;

    public ServingGuideline(Double servingQty, FoodType type) {
        super(servingQty);
        this.type = type;
    }
}
