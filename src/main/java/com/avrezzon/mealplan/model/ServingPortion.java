package com.avrezzon.mealplan.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ServingPortion extends Serving {
    private List<Food> foodList;

    public ServingPortion(Double servingQty, List<Food> foodList) {
        super(servingQty);
        this.foodList = foodList;
    }
}
