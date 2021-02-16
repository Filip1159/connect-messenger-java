package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Message getMessageByMessageId(long id);
}
