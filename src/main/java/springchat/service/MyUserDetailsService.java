package springchat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import springchat.config.MyUserDetails;
import springchat.model.User;
import springchat.repo.UserRepo;

@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);
        if(user == null) throw new UsernameNotFoundException("Can't find user");
        return new MyUserDetails(user);
    }
}
