package ru.idmikhailov.plastika.user;

import org.springframework.stereotype.Service;
import ru.idmikhailov.plastika.utils.UserStatus;

@Service
public class UserServiceImpl implements UserService {

    private final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void signUp(UserDTO user) {
        User databaseUser = userRepository.findByLogin(user.getLogin());
        if (databaseUser != null) {
            throw new RuntimeException("This login already exist");
        }
        databaseUser = new User(user);
        userRepository.save(databaseUser);
    }

    @Override
    public void ban(UserDTO user) {
        User databaseUser = userRepository.findByLogin(user.getLogin());
        databaseUser.setStatus(UserStatus.BANNED);
        userRepository.save(databaseUser);
    }

    @Override
    public void signIn(UserDTO user) {
        User databaseUser = userRepository.findByLogin(user.getLogin());
        if (databaseUser != null) {
            throw new RuntimeException("This user does not exist");
        }
    }
}
