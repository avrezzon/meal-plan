package com.avrezzon.mealplan.repository;

import com.avrezzon.mealplan.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    @SuppressWarnings("SpringDataMongoDBJsonFieldInspection")
    @Query("{username:'?0'}")
    User findUserByUsername(String username);
}
