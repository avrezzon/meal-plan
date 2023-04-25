package com.avrezzon.mealplan.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ValidationService {

    public String validateSessionUser(HttpSession session){
        String username = (String) session.getAttribute("username");
        if(Objects.isNull(username))
            throw new IllegalStateException("User needs to be logged in");
        return username;
    }
}
