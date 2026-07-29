package com.anaeltech.habits_api.config.storage;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

    private String location;

    private Folders folders;

    private List<String> allowedExtensions;

    private long maxFileSize;

    @Data
    public static class Folders {
        private String profilePicture;
    }
}
