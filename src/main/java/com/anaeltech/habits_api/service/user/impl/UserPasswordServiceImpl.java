package com.anaeltech.habits_api.service.user.impl;

import com.anaeltech.habits_api.exception.user.UserPasswordDoesNotMatch;
import com.anaeltech.habits_api.entity.User;
import com.anaeltech.habits_api.exception.user.UserNotFoundException;
import com.anaeltech.habits_api.repository.UserRepository;
import com.anaeltech.habits_api.service.user.UserPasswordService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserPasswordServiceImpl implements UserPasswordService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserPasswordServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new UserPasswordDoesNotMatch();
        }
        String hashedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

}
