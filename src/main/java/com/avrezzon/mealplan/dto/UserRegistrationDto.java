package com.avrezzon.mealplan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class UserRegistrationDto implements Serializable {
    private String username;
    private String email;
    private String firstname;
    private String lastname;
}
