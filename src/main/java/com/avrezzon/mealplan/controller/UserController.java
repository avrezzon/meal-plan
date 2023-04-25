package com.avrezzon.mealplan.controller;

import com.avrezzon.mealplan.dto.UserRegistrationDto;
import com.avrezzon.mealplan.model.Preferences;
import com.avrezzon.mealplan.model.User;
import com.avrezzon.mealplan.service.UserManagementService;
import com.avrezzon.mealplan.service.ValidationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    //NOTE: the two login and logout methods are ONLY for testing.
    //Once I get further with this, I will revisit this with spring security

    private final ValidationService validationService;
    private final ConversionService conversionService;
    private final UserManagementService userManagementService;

    @PostMapping("login")
    public void login(HttpSession session, @RequestParam String username) {
        log.info("Attempting to login for user: {}", username);

        String alteredUsername = username.trim();

        User user = userManagementService.findUser(alteredUsername);
        Optional<String> userLoggedIn = Optional.ofNullable((String) session.getAttribute("username"));

        if (userLoggedIn.isPresent() && !userLoggedIn.get().equals(alteredUsername)) {
            log.error("Someone else is logged in");
            throw new IllegalStateException("Another user is logged in");
        }

        session.setAttribute("username", user.getUsername());
        log.info("Login complete");
    }

    @PostMapping("register")
    public User registerUser(@RequestBody UserRegistrationDto dto){
        User userToRegister = conversionService.convert(dto, User.class);
        return userManagementService.registerUser(userToRegister);
    }

    @GetMapping("preferences")
    public Preferences getUserPreferences(HttpSession session){
        String username = validationService.validateSessionUser(session);
        User user = userManagementService.findUser(username);
        return user.getPreferences();
    }

    @PutMapping("preferences")
    public Preferences updateUserPreferences(HttpSession session, Preferences update){
        String username = validationService.validateSessionUser(session);
        User user = userManagementService.findUser(username);
        return user.getPreferences();
    }

}
