package com.avrezzon.mealplan.converter;

import com.avrezzon.mealplan.dto.UserRegistrationDto;
import com.avrezzon.mealplan.model.User;
import org.springframework.core.convert.converter.Converter;

public class UserRegistrationConverter implements Converter<UserRegistrationDto, User> {


    @Override
    public User convert(UserRegistrationDto source) {
        return User.builder()
                .username(source.getUsername())
                .email(source.getEmail())
                .firstname(source.getFirstname())
                .lastname(source.getLastname())
                .build();
    }
}
