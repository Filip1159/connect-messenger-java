package connect.messenger.model.dto;

import connect.messenger.model.Message;
import lombok.Builder;
import lombok.Getter;
import connect.messenger.model.Status;

import java.util.List;

@Getter
@Builder
public class ChatDto {
    private final Long id;
    private final List<Message> messages;
    private final List<UserDto> users;
    private final List<Status> status;  // statuses ???
}
