package com.javatraining.springchat.repository;

import com.javatraining.springchat.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    /*@Query(
            "select messages.content, users.name from messages, participants, users, " +
            "(" +
                "select max(messages.message_id) as message_id, conversations.conversation_id from messages, conversations" +
                "where conversations.conversation_id = messages.conversation_id" +
                "and conversations.conversation_id in" +
                "(" +
                    "select conversations.conversation_id from conversations, participants" +
                    "where conversations.conversation_id = participants.conversation_id" +
                    "and participants.user_id = 4" +
                ")" +
                "group by conversations.conversation_id" +
            ") as tab" +
            "where messages.message_id = tab.message_id" +
            "and participants.conversation_id = tab.conversation_id" +
            "and messages.user_id = users.user_id" +
            "and users.user_id = participants.user_id"
    )*/
    Conversation getConversationByConversationId(long conversationId);
}
