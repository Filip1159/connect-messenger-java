package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
    Message getMessageByMessageId(long id);
}
