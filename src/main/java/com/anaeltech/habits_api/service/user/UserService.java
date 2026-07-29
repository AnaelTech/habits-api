package com.anaeltech.habits_api.service.user;

import com.anaeltech.habits_api.dto.user.request.CreateUserRequest;
import com.anaeltech.habits_api.dto.user.request.UpdateUserRequest;
import com.anaeltech.habits_api.dto.user.response.UserResponse;

public interface UserService {

    UserResponse getUserById(Long userId);

    UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);

    UserResponse createUser(CreateUserRequest createUserRequest);

    void deleteUser(Long userId);
}
