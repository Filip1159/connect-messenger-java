package com.javatraining.springchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long conversationId;

    @OneToMany
    @JoinColumn(name = "messageId")
    private List<Message> messages;

    @OneToMany
    @JoinColumn(name = "participantId")
    private List<Participant> participants;
}
