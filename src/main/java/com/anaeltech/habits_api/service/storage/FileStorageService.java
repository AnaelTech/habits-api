package com.anaeltech.habits_api.service.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String upload(MultipartFile file);

    void delete(String filePath);
}
