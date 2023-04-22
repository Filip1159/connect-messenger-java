package connect.messenger.service;

import connect.messenger.model.dto.CreateMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import connect.messenger.model.Message;
import connect.messenger.repo.MessageRepo;

import javax.transaction.Transactional;
import java.io.*;

@Service
@RequiredArgsConstructor
public class MessageService {
    private static final String imageUploadFolder = "C:\\Users\\fwisn\\IdeaProjects\\connect-messenger-java\\src\\main\\resources\\static\\images\\";

    private final MessageRepo messageRepo;

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

        var originalFileExtension = message.fileContent().getOriginalFilename().split("[.]")[1];
        var newFileName = message.chatId() + "_" + savedMessage.getId() + "." + originalFileExtension;
        var newFilePath = imageUploadFolder + newFileName;

        var imageFile = new File(newFilePath);

        try (var inputStream = message.fileContent().getInputStream();
             var outputStream = new FileOutputStream(imageFile)) {
            if (!imageFile.exists()) imageFile.createNewFile();
            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
        }

        var messageContent = switch (message.type()) {
            case TEXT -> message.textContent();
            case FILE -> "/images/" + newFileName;
        };
        savedMessage.setContent(messageContent);
        return messageRepo.save(savedMessage);
    }
}
