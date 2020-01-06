package ru.idmikhailov.plastika.picture;

import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.UUID;

public class PictureServiceImpl implements PictureService {

    @Value("${imagesFolder}")
    private static String IMAGES_FOLDER;

    @Override
    public byte[] get(String id) throws IOException {
        String pathToImage = IMAGES_FOLDER + "/" + id + ".png";
        InputStream in = new FileInputStream(new File(pathToImage));

        return in.readAllBytes();
    }

    @Override
    public void save(byte[] picture) throws IOException {
        String pathToImage = IMAGES_FOLDER + "/" + UUID.randomUUID().toString() + ".png";
        File file= new File(pathToImage);
        if (!file.createNewFile()) {
            throw new IllegalArgumentException("this file already exists.");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(picture);
    }

    @Override
    public void delete(String id) {
        String pathToImage = IMAGES_FOLDER + "/" + id + ".png";
        File file = new File(pathToImage);

        if (!file.delete()) {
           throw new IllegalArgumentException("this file does not exists.");
        }
    }
}
