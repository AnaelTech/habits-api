package com.anaeltech.habits_api.dto.user.response;

public record UserResponse(
        Long id,
        String email,
        String firstName,
        String lastName) {

}
