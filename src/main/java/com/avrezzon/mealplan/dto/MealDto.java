package com.avrezzon.mealplan.dto;

import com.avrezzon.mealplan.model.MealType;
import com.avrezzon.mealplan.model.ServingPortion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDto implements Serializable {



    private MealType name;
    private List<ServingPortion> servingPortions;

}
