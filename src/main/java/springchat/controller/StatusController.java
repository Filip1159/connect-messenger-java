package springchat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springchat.model.Status;
import springchat.repo.StatusRepo;

@RestController
@RequiredArgsConstructor
public class StatusController {

    private final StatusRepo statusRepo;
    private final SimpMessagingTemplate template;

    @PutMapping("/status")
    public void updateStatus(@RequestBody Status status) {
        statusRepo.save(status);
        System.out.println("Status: " + status);
        template.convertAndSend("/topic/messages/" + status.getId().getChatId(), status);
    }
}
