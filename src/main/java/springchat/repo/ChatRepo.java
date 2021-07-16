package springchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springchat.model.Chat;
import springchat.model.User;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Chat, Long> {
    List<Chat> findChatsByUsersContaining(User user);
}
