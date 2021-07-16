package springchat.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id")
    private List<Message> messages;

    @ManyToMany(mappedBy = "chats")
    List<User> users;

    @OneToMany
    @JoinColumn(name = "chat_id")
    List<Status> status;
}
