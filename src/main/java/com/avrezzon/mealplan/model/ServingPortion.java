package com.avrezzon.mealplan.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class ServingPortion extends Serving {
    private List<Food> foodList;

    public ServingPortion(Double servingQty, FoodType type, List<Food> foodList) {
        super(servingQty, type);
        this.foodList = foodList;
    }
}
