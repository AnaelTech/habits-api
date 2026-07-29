package com.anaeltech.habits_api.exception.user;

public class UserPasswordDoesNotMatch extends RuntimeException {

    public UserPasswordDoesNotMatch() {
        super("User password does not match");
    }

}
