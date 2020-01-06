package ru.idmikhailov.plastika.utils;

import java.io.File;
import java.net.URL;

public class FileUtils {

    public static File getFileFromResourcesFolder(String fileName) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("this file was not found");
        }

        return new File(resource.getFile());
    }
}
