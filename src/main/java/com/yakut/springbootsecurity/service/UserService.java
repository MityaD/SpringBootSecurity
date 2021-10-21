package com.yakut.springbootsecurity.service;

import com.yakut.springbootsecurity.exception.NoUserTableException;
import com.yakut.springbootsecurity.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {
    User save(User user);

    void deleteUserById(Long id);

    List<User> findAllUser();

    User findUserById(Long id) throws NoUserTableException;

    void deleteAll();
}
