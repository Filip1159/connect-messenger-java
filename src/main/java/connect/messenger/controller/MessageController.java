package connect.messenger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import connect.messenger.model.Message;
import connect.messenger.service.MessageService;

@RestController
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
        Message added = messageService.addMessage(message);
        template.convertAndSend("/topic/messages/" + added.getChatId(), added);
        return added;
    }
}
