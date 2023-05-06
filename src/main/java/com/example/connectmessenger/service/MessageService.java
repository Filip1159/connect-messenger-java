package com.example.connectmessenger.service;

import com.example.connectmessenger.model.Message;
import com.example.connectmessenger.model.MessageType;
import com.example.connectmessenger.model.dto.CreateMessageRequest;
import com.example.connectmessenger.repo.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;
    private final AwsS3Client s3Client;

    public Message getMessageById(Long id) {
        return messageRepo.getMessageById(id);
    }

    @Transactional
    public Message addMessage(CreateMessageRequest message) {
        var messageEntity = Message.builder()
                .chatId(message.chatId())
                .userId(message.userId())
                .time(message.time())
                .type(message.type())
                .content("")
                .build();
        var savedMessage = messageRepo.save(messageEntity);

        var messageContent = getMessageContent(message, savedMessage.getId());
        savedMessage.setContent(messageContent);
        return messageRepo.save(savedMessage);
    }

    public String getMessageContent(CreateMessageRequest message, Long savedMessageId) {
        if (message.type().equals(MessageType.FILE)) {
            var originalFileExtension = message.fileContent().getOriginalFilename().split("[.]")[1];
            var newFileName = message.chatId() + "_" + savedMessageId + "." + originalFileExtension;
            s3Client.putFile(newFileName, message.fileContent());
            return newFileName;
        } else {
            return message.textContent();
        }
    }
}
