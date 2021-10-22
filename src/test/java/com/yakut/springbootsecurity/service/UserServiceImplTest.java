package com.yakut.springbootsecurity.service;

import com.yakut.springbootsecurity.exception.NoUserTableException;
import com.yakut.springbootsecurity.model.User;
import com.yakut.springbootsecurity.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void save() {
        User user = new User("AAA", "AAAA", 11);
        doReturn(user).when(userRepository).save(user);
        assertEquals(user, userService.save(user));
    }

    @Test
    void findAllUser() {
        List<User> userList = List.of(
                new User("AAA", "AAAA", 11),
                new User("BBB", "BBBB", 22),
                new User("CCC", "CCCC", 33)
        );
        doReturn(userList).when(userRepository).findAll();
        assertEquals(userList, userRepository.findAll());
    }

    @Test
    void findUserById() throws NoUserTableException {
        List<User> userList = List.of(
                new User(1L,"AAA", "AAAA", 11),
                new User(2L,"BBB", "BBBB", 22)
        );
        when(userRepository.findById(2L)).thenReturn(Optional.of(userList.get(1)));
        assertEquals(userList.get(1), userService.findUserById(2L));
    }

    @Test
    void loadUserByUsername() {
        List<User> userList = List.of(
                new User("AAA", "AAAA", 11),
                new User("BBB", "BBBB", 22)
        );
        when(userRepository.findByFirstName("AAA")).thenReturn(Optional.ofNullable((userList.get(0))));
        assertEquals(userList.get(0), userService.loadUserByUsername("AAA"));
    }

    @Test
    void deleteUserById(){
        userService.deleteUserById(1L);
        verify(userRepository).deleteById(1L);
    }

    @Test
    void deleteAll() {
        userService.deleteAll();
        verify(userRepository).deleteAll();
    }
}
