package ru.idmikhailov.plastika.picture;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public interface PictureService {

    byte[] get(String id) throws IOException;

    void save(byte[] picture) throws IOException;

    void delete (String id) throws FileNotFoundException;

}
