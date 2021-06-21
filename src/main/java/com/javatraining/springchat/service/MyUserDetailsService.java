package com.javatraining.springchat.service;

import com.javatraining.springchat.config.MyUserDetails;
import com.javatraining.springchat.model.User;
import com.javatraining.springchat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("CoUlD nOt FiNd UsEr!!!!!");
        }
        return new MyUserDetails(user);
    }
}
