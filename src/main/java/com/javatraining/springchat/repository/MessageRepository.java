package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message getMessageByMessageId(long id);
    List<Message> getMessagesByConversationIdIn(List<Long> ids);
    List<Message> getMessagesByUserId(long userId);
}
