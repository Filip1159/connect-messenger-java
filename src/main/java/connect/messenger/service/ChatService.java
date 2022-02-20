package connect.messenger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import connect.messenger.model.Chat;
import connect.messenger.model.User;
import connect.messenger.model.dto.ChatDto;
import connect.messenger.model.dto.ChatDtoMapper;
import connect.messenger.repo.ChatRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepo chatRepo;

    public ChatDto getChatById(Long id) {
        Chat c = chatRepo.findById(id).orElse(null);
        if(c == null) return null;
        return ChatDtoMapper.mapToChatDto(c);
    }

    public List<ChatDto> getUserChats(User user) {
        List<Chat> chats = chatRepo.findChatsByUsersContaining(user);
        return ChatDtoMapper.mapToChatDtos(chats);
    }
}
