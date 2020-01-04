package ru.idmikhailov.plastika.user;

public interface UserService {
    User get(String login);
    void signUp(UserDTO user);

    void ban(UserDTO user);

    void signIn(UserDTO user);
}
