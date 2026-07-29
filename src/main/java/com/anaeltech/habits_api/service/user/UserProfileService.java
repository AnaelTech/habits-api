package com.anaeltech.habits_api.service.user;

import org.springframework.web.multipart.MultipartFile;

public interface UserProfileService {

    String uploadProfilePicture(Long userId, MultipartFile pictureData);

}
