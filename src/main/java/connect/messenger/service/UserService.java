package connect.messenger.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import connect.messenger.model.User;
import connect.messenger.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    public List<User> getUsersByQuery(String text) {
        return userRepo.getAllByUsernameContainingOrNameContainingOrSurnameContaining(text, text, text);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.getUserByUsername(username).orElseThrow();
    }
}
