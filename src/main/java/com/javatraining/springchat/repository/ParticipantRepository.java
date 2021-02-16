package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant getParticipantByParticipantId(long participantId);
    List<Participant> getParticipantsByConversationId(long conversationId);
    List<Participant> getParticipantsByUserId(long userId);
    List<Participant> getParticipantsByConversationIdInAndUserIdIsNot(List<Long> conversationsIds, long userId);
}
