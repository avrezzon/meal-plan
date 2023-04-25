package com.avrezzon.mealplan.service;

import com.avrezzon.mealplan.model.User;
import com.avrezzon.mealplan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository repository;

    public User findUser(String username){
        return Optional.ofNullable(repository.findUserByUsername(username))
                .orElseThrow(() -> new IllegalStateException("Cannot find registered username"));
    }

    public User registerUser(User user){
        return repository.save(user);
    }
}
