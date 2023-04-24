package connect.messenger.service;

import connect.messenger.model.Chat;
import connect.messenger.model.Status;
import connect.messenger.model.StatusEmbeddedId;
import connect.messenger.model.User;
import connect.messenger.model.dto.ChatDto;
import connect.messenger.model.dto.ChatDtoMapper;
import connect.messenger.model.dto.CreateChatRequest;
import connect.messenger.repo.ChatRepo;
import connect.messenger.repo.StatusRepo;
import connect.messenger.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepo chatRepo;
    private final StatusRepo statusRepo;
    private final UserRepo userRepo;

    public ChatDto getChatById(Long id) {
        Chat c = chatRepo.findById(id).orElse(null);
        if (c == null) return null;
        return ChatDtoMapper.mapToChatDto(c);
    }

    public List<ChatDto> getUserChats(User user) {
        List<Chat> chats = chatRepo.findChatsByUsersContaining(user);
        return ChatDtoMapper.mapToChatDtos(chats);
    }

    public ChatDto createChat(CreateChatRequest request) {
        var users = request.userIds().stream()
                .map(id -> userRepo.findById(id).orElseThrow())
                .toList();

        var newChat = Chat.builder()
                .users(users)
                .messages(List.of())
                .status(List.of())
                .build();
        var savedChat = chatRepo.save(newChat);

        var newStatuses = users.stream()
                .map(user -> Status.builder()
                        .messageId(null)
                        .time(null)
                        .id(StatusEmbeddedId.builder()
                                .userId(user.getId())
                                .chatId(savedChat.getId())
                                .build())
                        .build())
                .toList();

        statusRepo.saveAll(newStatuses);
        savedChat.setStatus(newStatuses);

        return ChatDtoMapper.mapToChatDto(savedChat);
    }
}
