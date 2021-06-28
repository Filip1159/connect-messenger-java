package springchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long conversationId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "conversationId")
    private List<Message> messages;

    @ManyToMany(mappedBy = "conversations")
    List<User> users;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversationId")
    private List<SeenMap> seenMapList;

    @Override
    public String toString() {
        return "Conversation{" +
                "conversationId=" + conversationId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o instanceof Conversation) {
            Conversation c = (Conversation) o;
            return c.conversationId == conversationId;
        }
        return false;
    }
}
