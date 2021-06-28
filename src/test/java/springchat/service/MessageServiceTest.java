package springchat.service;

import springchat.model.Message;
import springchat.repository.MessageRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MessageServiceTest {
    @Autowired
    private MessageRepo messageRepo;

    @Test
    public void shouldGetSingleMessage() {
        Message message = messageRepo.getMessageByMessageId(1);
        assertThat(message).isNotNull();
        assertThat(message.getContent()).isEqualTo("Hey John, whats up?");
    }

}