package com.anaeltech.habits_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.anaeltech.habits_api.dto.user.request.UpdateUserRequest;
import com.anaeltech.habits_api.dto.user.request.CreateUserRequest;
import com.anaeltech.habits_api.dto.user.response.UserProfileResponse;
import com.anaeltech.habits_api.dto.user.response.UserResponse;
import com.anaeltech.habits_api.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Map a User entity to a UserResponse DTO
    UserResponse toResponse(User user);

    // Map a User entity to a UserProfileResponse DTO
    UserProfileResponse toProfileResponse(User user);

    // Create a new User entity from the CreateUserRequest
    User toEntity(CreateUserRequest request);

    // Update the existing User entity with the values from the UpdateUserRequest
    // with no data loss because of null values in the request.
    void updateEntity(
            UpdateUserRequest request,
            @MappingTarget User user);

}
