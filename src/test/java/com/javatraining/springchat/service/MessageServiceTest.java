package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.repository.MessageRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageServiceTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void shouldGetSingleMessage() {
        //given
        //when
        Message message = messageRepository.getMessageByMessageId(1);
        //then
        Assertions.assertThat(message).isNotNull();
        Assertions.assertThat(message.getContent()).isEqualTo("Hey John, whats up?");
    }

}