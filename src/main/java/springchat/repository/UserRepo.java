package springchat.repository;

import springchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
    List<User> getAllByUsernameContainingOrNameContainingOrSurnameContaining(String text1, String text2, String text3);
}
