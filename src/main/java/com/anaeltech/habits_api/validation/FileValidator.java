package com.anaeltech.habits_api.validation;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.anaeltech.habits_api.config.storage.StorageProperties;

@Component
public class FileValidator {

    private final StorageProperties storageProperties;

    public FileValidator(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    public void validate(MultipartFile file) {
        validateNotEmpty(file);
        validateExtension(file);
        validateContentType(file);
        validateSize(file);
    }

    private void validateNotEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty.");
        }
    }

    private void validateExtension(MultipartFile file) {
        String filename = file.getOriginalFilename();
        String extension = filename != null ? filename.substring(filename.lastIndexOf(".") + 1) : "";
        if (!storageProperties.getAllowedExtensions().contains(extension.toLowerCase())) {
            throw new IllegalArgumentException("Invalid file extension: " + extension);
        }
    }

    private void validateContentType(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("Invalid content type: " + contentType);
        }
    }

    private void validateSize(MultipartFile file) {
        long maxSize = storageProperties.getMaxFileSize();
        if (file.getSize() > maxSize) {
            throw new IllegalArgumentException("File size exceeds the maximum limit of 5 MB.");
        }
    }
}
