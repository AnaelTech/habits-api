package com.anaeltech.habits_api.exception.user;

public class UserEmailAlreadyExist extends RuntimeException {

    public UserEmailAlreadyExist(String email) {
        super("User with email " + email + " already exists");
    }

}
