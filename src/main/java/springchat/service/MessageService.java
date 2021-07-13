package springchat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springchat.model.Message;
import springchat.repo.MessageRepo;

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
