package connect.messenger.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import connect.messenger.model.Status;
import connect.messenger.model.StatusEmbeddedId;

public interface StatusRepo extends JpaRepository<Status, StatusEmbeddedId> {
}
