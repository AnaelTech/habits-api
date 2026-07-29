package com.anaeltech.habits_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anaeltech.habits_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // Optional is used to handle the case where a user with the given email may not
    // exist in the database. It allows for a more expressive way to handle the
    // absence of a value, avoiding potential NullPointerExceptions.
    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);

}
