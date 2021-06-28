package springchat.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private final long userId;
    private final String name, surname, username;
}
