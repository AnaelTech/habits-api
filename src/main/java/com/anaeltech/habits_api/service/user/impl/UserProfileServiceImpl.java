package com.anaeltech.habits_api.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anaeltech.habits_api.exception.user.UserNotFoundException;
import com.anaeltech.habits_api.service.storage.impl.FileStorageServiceImpl;

import com.anaeltech.habits_api.entity.User;
import com.anaeltech.habits_api.repository.UserRepository;
import com.anaeltech.habits_api.service.user.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserRepository userRepository;
    private final FileStorageServiceImpl fileStorageService;

    public UserProfileServiceImpl(UserRepository userRepository, FileStorageServiceImpl fileStorageService) {
        this.userRepository = userRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public String uploadProfilePicture(Long userId, MultipartFile pictureData) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        String filePath = fileStorageService.upload(pictureData);
        user.setAvatarUrl(filePath);
        userRepository.save(user);
        return filePath;
    }

}
