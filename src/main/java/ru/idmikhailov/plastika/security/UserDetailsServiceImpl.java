package ru.idmikhailov.plastika.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.idmikhailov.plastika.user.User;
import ru.idmikhailov.plastika.user.UserService;
import ru.idmikhailov.plastika.utils.UserStatus;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final
    UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.get(username);
        Set<GrantedAuthority> roles = new HashSet<>();
        if (user.getStatus() == null) {
            roles.add(new SimpleGrantedAuthority(UserStatus.USER.name()));
        }
        else {
            roles.add(new SimpleGrantedAuthority(user.getStatus().name()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), roles);
    }
}
