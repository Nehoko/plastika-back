package ru.idmikhailov.plastika.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.idmikhailov.plastika.utils.UserStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class User {

    @Id
    private Long id;
    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User() {

    }
}