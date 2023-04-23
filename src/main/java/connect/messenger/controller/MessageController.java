package connect.messenger.controller;

import connect.messenger.model.Message;
import connect.messenger.model.dto.CreateMessageRequest;
import connect.messenger.service.AwsS3Client;
import connect.messenger.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final AwsS3Client awsS3Client;
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

    @GetMapping("/message/file/{fileName}")
    String getMessageImage(@PathVariable String fileName) {
        return Base64.getEncoder().encodeToString(awsS3Client.getFile(fileName));
    }
}
