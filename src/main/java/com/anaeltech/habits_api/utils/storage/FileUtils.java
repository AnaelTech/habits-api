package com.anaeltech.habits_api.utils.storage;

public final class FileUtils {

    private FileUtils() {
    }

    public static String getExtension(String filename) {
        if (filename == null || filename.isBlank()) {
            return "";
        }

        int index = filename.lastIndexOf(".");

        return index > 0
                ? filename.substring(index)
                : "";
    }
}
