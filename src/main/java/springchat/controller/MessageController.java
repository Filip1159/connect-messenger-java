package springchat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import springchat.model.Message;
import springchat.service.MessageService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final SimpMessagingTemplate template;

    @GetMapping("/message/{id}")
    public Message getMessageById(@PathVariable long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping("/message")
    public Message postMessage(@RequestBody Message message) {
        template.convertAndSend("/topic/messages/" + message.getConversationId(), message);
        return messageService.addMessage(message);
    }
}
