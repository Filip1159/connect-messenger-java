package com.javatraining.springchat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConversationServiceTest {
    @Autowired
    private ConversationService conversationService;
    /*@Test
    public void shouldFetchJansConversations() {
        List<Conversation> jansConvs = conversationService.getConversationsByUserId(1);
        assertThat(jansConvs).isNotNull();
        assertThat(jansConvs.get(0).getMessages().get(0).getContent()).isEqualTo("Hej Ewa, pożycz dwie dychy do jutra");
        assertEquals("Hej Ewa, pożycz dwie dychy do jutra", jansConvs.get(0).getMessages().get(0).getContent());
    }*/

}