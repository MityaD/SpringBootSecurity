package com.yakut.springbootsecurity.service;

import com.yakut.springbootsecurity.exception.NoUserTableException;
import com.yakut.springbootsecurity.model.User;
import com.yakut.springbootsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User findUserById(Long id) throws NoUserTableException {
        return userRepository.findById(id).orElseThrow(() -> new NoUserTableException(id));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByFirstName(username);
    }
}
