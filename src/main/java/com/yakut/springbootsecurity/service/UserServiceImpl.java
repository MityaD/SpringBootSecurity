package com.yakut.springbootsecurity.service;

import com.yakut.springbootsecurity.exception.ExceptionByIdUser;
import com.yakut.springbootsecurity.exception.ExceptionByUserName;
import com.yakut.springbootsecurity.exception.NoUserTableException;
import com.yakut.springbootsecurity.model.User;
import com.yakut.springbootsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Long id) throws NoUserTableException {
        return userRepository.findById(id).orElseThrow(() -> new NoUserTableException(id));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByFirstName(username).orElseThrow(ExceptionByUserName::new);
    }
}
