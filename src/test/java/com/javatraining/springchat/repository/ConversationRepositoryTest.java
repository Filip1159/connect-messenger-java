package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ConversationRepositoryTest {
    @Autowired
    private ConversationRepository conversationRepository;

    @Test
    public void shouldReturnJanekConversations() {
        User u = new User();
        u.setUserId(1);
        u.setUsername("janek007");
        u.setName("Jan");
        u.setSurname("Kowalski");
        List<Conversation> convs = conversationRepository.findConversationsByUsersContaining(u);
        assertThat(convs.size()).isEqualTo(3);
        assertThat(convs.get(0).getMessages().get(0).getContent()).isEqualTo("Hey John, whats up?");
        assertThat(convs.get(1).getMessages().get(0).getContent()).isEqualTo("Czesc Jan, co tam?");
    }

}