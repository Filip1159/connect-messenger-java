package connect.messenger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import connect.messenger.model.User;
import connect.messenger.model.dto.ChatDto;
import connect.messenger.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/{userId}")
    public List<ChatDto> getChatsByUserId(@PathVariable Long userId) {
        User u = new User();
        u.setId(userId);
        return chatService.getUserChats(u);
    }

    @GetMapping("/chat/{id}")
    public ChatDto getChatById(@PathVariable Long id) {
        return chatService.getChatById(id);
    }
}
