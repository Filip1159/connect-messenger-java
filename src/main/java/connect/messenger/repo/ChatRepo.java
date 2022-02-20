package connect.messenger.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import connect.messenger.model.Chat;
import connect.messenger.model.User;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Chat, Long> {
    List<Chat> findChatsByUsersContaining(User user);
}
