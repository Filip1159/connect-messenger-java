package springchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "conversation_seen_mapping")
public class SeenMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long conversationId;
    private long messageId;
    private long userId;
    private LocalDateTime time;

    @Override
    public String toString() {
        return "In conversation " + conversationId + " user " + userId + " seen message with id = " + messageId + " at " + time;
    }
}
