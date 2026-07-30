package com.anaeltech.habits_api.service.user.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anaeltech.habits_api.exception.user.UserEmailAlreadyExistException;
import com.anaeltech.habits_api.exception.user.UserNotFoundException;
import com.anaeltech.habits_api.mapper.UserMapper;
import com.anaeltech.habits_api.repository.UserRepository;
import com.anaeltech.habits_api.dto.user.request.CreateUserRequest;
import com.anaeltech.habits_api.dto.user.request.UpdateUserRequest;
import com.anaeltech.habits_api.dto.user.response.UserResponse;
import com.anaeltech.habits_api.entity.User;
import com.anaeltech.habits_api.service.user.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        userMapper.updateEntity(updateUserRequest, user);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponse(updatedUser);
    }

    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user = userMapper.toEntity(createUserRequest);
        user.setPassword(
                passwordEncoder.encode(createUserRequest.password()));
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserEmailAlreadyExistException(user.getEmail());
        }

        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.delete(user);
    }

}
