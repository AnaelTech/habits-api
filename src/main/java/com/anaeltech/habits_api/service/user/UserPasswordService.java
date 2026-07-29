package com.anaeltech.habits_api.service.user;

public interface UserPasswordService {

    void changePassword(Long userId, String oldPassword, String newPassword);

}
