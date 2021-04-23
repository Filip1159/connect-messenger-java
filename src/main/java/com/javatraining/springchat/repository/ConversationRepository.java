package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    Conversation getConversationByConversationId(long conversationId);
    List<Conversation> findConversationsByConversationIdIn(List<Long> ids);
    List<Conversation> findConversationsByUsersContaining(User user);
}
