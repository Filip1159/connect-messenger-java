package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnJanek007() {
        User u = userRepository.getUserByUsernameContaining("janek");
        assertThat(u.getName()).isEqualTo("Jan");
        assertThat(u.getUsername()).isEqualTo("janek007");
    }
}