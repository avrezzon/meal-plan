package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@Builder
@Document("User")
public class User{


    @MongoId
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private Preferences preferences;

}
