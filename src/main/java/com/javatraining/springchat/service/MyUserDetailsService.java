package com.javatraining.springchat.service;

import com.javatraining.springchat.config.MyUserDetails;
import com.javatraining.springchat.model.User;
import com.javatraining.springchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("CoUlD nOt FiNd UsEr!!!!!");
        }
        return new MyUserDetails(user);
    }
}
