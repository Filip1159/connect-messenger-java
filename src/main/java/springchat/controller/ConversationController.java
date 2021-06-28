package springchat.controller;

import springchat.model.User;
import springchat.model.dto.ConversationDTO;
import springchat.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversations")
@RequiredArgsConstructor
public class ConversationController {
    private final ConversationService conversationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{userId}")
    public List<ConversationDTO> getConversations(@PathVariable long userId) {
        User u = new User();
        u.setUserId(userId);
        return conversationService.getUserConversations(u);
    }

    @GetMapping("/conv/{convId}")
    public ConversationDTO getConversationByUserId(@PathVariable long convId) {
        return conversationService.getConversationById(convId);
    }
}
