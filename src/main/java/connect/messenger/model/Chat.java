package connect.messenger.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatId")
    private List<Message> messages;

    @ManyToMany(mappedBy = "chats")
    List<User> users;

    @OneToMany
    @JoinColumn(name = "chatId")
    List<Status> status;
}
