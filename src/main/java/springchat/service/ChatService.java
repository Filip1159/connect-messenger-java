package springchat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springchat.model.Chat;
import springchat.model.User;
import springchat.model.dto.ChatDto;
import springchat.model.dto.ChatDtoMapper;
import springchat.repo.ChatRepo;

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
