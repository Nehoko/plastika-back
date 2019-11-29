package ru.idmikhailov.plastika.user;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
    User findByLogin(String login);
}
