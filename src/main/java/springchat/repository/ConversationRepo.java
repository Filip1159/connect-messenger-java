package springchat.repository;

import springchat.model.Conversation;
import springchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepo extends JpaRepository<Conversation, Long> {
    List<Conversation> findConversationsByUsersContaining(User user);
}
