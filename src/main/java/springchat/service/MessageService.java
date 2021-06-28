package springchat.service;

import springchat.model.Message;
import springchat.repository.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;

    public Message getMessageById(long id) {
        return messageRepo.getMessageByMessageId(id);
    }

    public Message addMessage(Message message) {
        return messageRepo.save(message);
    }
}
