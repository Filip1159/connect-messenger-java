package springchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long messageId;
    private long conversationId;
    private long userId;
    private LocalDateTime time;
    private String content;

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", conversationId=" + conversationId +
                ", userId=" + userId +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
