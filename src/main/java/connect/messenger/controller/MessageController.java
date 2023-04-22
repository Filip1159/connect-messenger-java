package connect.messenger.controller;

import connect.messenger.model.dto.CreateMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import connect.messenger.model.Message;
import connect.messenger.service.MessageService;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final SimpMessagingTemplate template;

    @GetMapping("/message/{id}")
    public Message getMessageById(@PathVariable long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping(value = "/message", consumes = MULTIPART_FORM_DATA_VALUE)
    public Message postMessage(CreateMessageRequest message) {
        Message added = messageService.addMessage(message);
        template.convertAndSend("/topic/messages/" + added.getChatId(), added);
        return added;
    }
}
