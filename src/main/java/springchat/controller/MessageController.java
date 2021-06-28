package springchat.controller;

import springchat.model.Message;
import springchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping("")
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }
}
