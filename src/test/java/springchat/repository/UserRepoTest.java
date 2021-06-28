package springchat.repository;

import springchat.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void shouldReturnJanek007() {
        User u = userRepo.getAllByUsernameContainingOrNameContainingOrSurnameContaining("janek", "janek", "janek").get(0);
        assertThat(u.getName()).isEqualTo("Jan");
        assertThat(u.getUsername()).isEqualTo("janek007");
    }
}