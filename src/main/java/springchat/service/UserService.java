package springchat.service;

import springchat.model.User;
import springchat.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> getUsersByQuery(String text) {
        return userRepo.getAllByUsernameContainingOrNameContainingOrSurnameContaining(text, text, text);
    }
}
