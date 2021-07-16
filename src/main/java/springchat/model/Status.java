package springchat.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "status")
public class Status {
    @EmbeddedId
    private StatusEmbeddedId id;
    private Long messageId;  // last displayed message
    private LocalDateTime time;  // when last message was displayed first time
}
