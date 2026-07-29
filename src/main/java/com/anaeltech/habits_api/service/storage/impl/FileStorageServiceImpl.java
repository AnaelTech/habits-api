package com.anaeltech.habits_api.service.storage.impl;

import com.anaeltech.habits_api.config.storage.StorageProperties;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import com.anaeltech.habits_api.exception.storage.StorageException;
import com.anaeltech.habits_api.service.storage.FileStorageService;
import com.anaeltech.habits_api.utils.storage.FileUtils;
import com.anaeltech.habits_api.validation.FileValidator;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path rootLocation;
    private final String profilePictureFolder;
    private final FileValidator fileValidator;

    public FileStorageServiceImpl(StorageProperties storageProperties) {
        this.rootLocation = Paths.get(storageProperties.getLocation());
        this.profilePictureFolder = storageProperties.getFolders().getProfilePicture();
        this.fileValidator = new FileValidator(storageProperties);
    }

    @Override
    public String upload(MultipartFile file) {
        try {
            fileValidator.validate(file);

            String extension = FileUtils.getExtension(file.getOriginalFilename());

            String filename = UUID.randomUUID().toString() + extension;

            Files.createDirectories(rootLocation.resolve(profilePictureFolder));

            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(profilePictureFolder, filename))
                    .normalize().toAbsolutePath();

            if (!destinationFile.getParent().equals(this.rootLocation.resolve(profilePictureFolder).toAbsolutePath())) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
            return profilePictureFolder + "/" + filename;

        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public void delete(String filePath) {
        Path file = rootLocation.resolve(filePath).normalize();

        if (!file.startsWith(rootLocation)) {
            throw new StorageException("Invalid file path");
        }

        FileSystemUtils.deleteRecursively(file.toFile());
    }

}
