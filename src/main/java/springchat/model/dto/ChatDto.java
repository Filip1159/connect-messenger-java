package springchat.model.dto;

import springchat.model.Message;
import lombok.Builder;
import lombok.Getter;
import springchat.model.Status;

import java.util.List;

@Getter
@Builder
public class ChatDto {
    private final Long id;
    private final List<Message> messages;
    private final List<UserDto> users;
    private final List<Status> status;  // statuses ???
}
