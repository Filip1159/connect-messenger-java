package springchat.controller;

import springchat.model.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void shouldFindJanAndJohn() {
        List<UserDTO> users = userController.getUsersByQuery("ja");
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getName()).isEqualTo("Jan");

        users = userController.getUsersByQuery("oms");
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getName()).isEqualTo("Grace");

        users = userController.getUsersByQuery("0");
        assertThat(users.size()).isEqualTo(2);
    }
}