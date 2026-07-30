package com.anaeltech.habits_api.exception.user;

public class UserPasswordDoesNotMatchException extends RuntimeException {

    public UserPasswordDoesNotMatchException() {
        super("User password does not match");
    }

}
