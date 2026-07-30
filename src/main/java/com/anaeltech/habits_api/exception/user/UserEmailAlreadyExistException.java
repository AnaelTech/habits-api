package com.anaeltech.habits_api.exception.user;

public class UserEmailAlreadyExistException extends RuntimeException {

    public UserEmailAlreadyExistException(String email) {
        super("User with email " + email + " already exists");
    }

}
