package com.yakut.springbootsecurity.repository;

import com.yakut.springbootsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByFirstName(String username);
}
