package ru.idmikhailov.plastika.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.idmikhailov.plastika.utils.UserStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@Data
public class UserDTO {
    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public UserDTO() {}
}
