package connect.messenger.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class StatusEmbeddedId implements Serializable {
    private Long userId;
    private Long chatId;
}
