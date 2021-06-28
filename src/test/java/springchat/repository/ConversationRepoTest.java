package springchat.repository;

import springchat.model.Conversation;
import springchat.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ConversationRepoTest {
    @Autowired
    private ConversationRepo conversationRepo;

    @Test
    public void shouldReturnJanekConversations() {
        User u = new User();
        u.setUserId(1);
        List<Conversation> convs = conversationRepo.findConversationsByUsersContaining(u);
        assertThat(convs.size()).isEqualTo(3);
        assertThat(convs.get(0).getMessages().get(0).getContent()).isEqualTo("Hej Ewa, pożycz dwie dychy do jutra");
        assertThat(convs.get(1).getMessages().get(1).getContent()).isEqualTo("W nastepny czwartek");
    }

}