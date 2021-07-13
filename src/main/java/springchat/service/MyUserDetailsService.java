package springchat.service;

import springchat.config.MyUserDetails;
import springchat.model.User;
import springchat.repo.UserRepo;
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
