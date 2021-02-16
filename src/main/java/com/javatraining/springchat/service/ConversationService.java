package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.model.Participant;
import com.javatraining.springchat.repository.ConversationRepository;
import com.javatraining.springchat.repository.MessageRepository;
import com.javatraining.springchat.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ConversationService {
    private final ConversationRepository conversationRepository;
    private final ParticipantRepository participantRepository;
    private final MessageRepository messageRepository;

    public List<Conversation> getConversationsByUserId(long userId) {
        List<Participant> participants = participantRepository.getParticipantsByUserId(userId);
        List<Long> ids = participants.stream()
                .map(Participant::getConversationId)
                .collect(Collectors.toList());
        List<Conversation> conversations = conversationRepository.findConversationsByConversationIdIn(ids);
        List<Message> messages = messageRepository.getMessagesByConversationIdIn(ids);
        List<Participant> participants2 = participantRepository.getParticipantsByConversationIdInAndUserIdIsNot(ids, userId);

        conversations.forEach(conversation -> conversation.setMessages(
                messages.stream()
                .filter(message -> message.getConversationId() == conversation.getConversationId())
                .collect(Collectors.toList())
        ));
        conversations.forEach(conversation -> conversation.setParticipants(
                participants2.stream()
                .filter(participant2 -> participant2.getConversationId() == conversation.getConversationId())
                .collect(Collectors.toList())
        ));
        return conversations;
    }
}
