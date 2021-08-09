package springchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springchat.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> getUserByUsername(String username);
    List<User> getAllByUsernameContainingOrNameContainingOrSurnameContaining(String text1, String text2, String text3);
}
