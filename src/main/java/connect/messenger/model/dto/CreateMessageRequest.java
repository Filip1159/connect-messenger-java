package connect.messenger.model.dto;

import connect.messenger.model.MessageType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public record CreateMessageRequest(
        Long chatId,
        Long userId,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime time,
        MessageType type,
        String textContent,
        MultipartFile fileContent
) {
}
