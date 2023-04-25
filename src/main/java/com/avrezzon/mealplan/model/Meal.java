package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Document("Meal")
public class Meal implements Serializable {

    @Id
    private MealReference id;

    private List<ServingPortion> servingPortions;

    @Data
    @Builder
    @AllArgsConstructor
    public static class MealReference{
        private LocalDate date;
        private MealType mealType;
        private String username;
    }

}
