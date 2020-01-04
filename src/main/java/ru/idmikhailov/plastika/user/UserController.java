package ru.idmikhailov.plastika.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity signIn(@RequestBody UserDTO user) {
        userService.signIn(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity signUp(@RequestBody UserDTO user) {
        userService.signUp(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/ban", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity ban(@RequestBody UserDTO user) {
        userService.ban(user);

        return new ResponseEntity(HttpStatus.OK);
    }
}
