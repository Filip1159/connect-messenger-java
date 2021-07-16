package springchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springchat.model.Status;
import springchat.model.StatusEmbeddedId;

public interface StatusRepo extends JpaRepository<Status, StatusEmbeddedId> {
}
