package ru.idmikhailov.plastika.picture;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("api/picture")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> get(@PathVariable String id) throws IOException {

        byte[] picture = pictureService.get(id);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(picture);
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST, consumes = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity save (@RequestBody MultipartFile file) throws IOException {

        pictureService.save(file.getBytes())         ;
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity delete(@PathVariable String id) throws FileNotFoundException {

        pictureService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
