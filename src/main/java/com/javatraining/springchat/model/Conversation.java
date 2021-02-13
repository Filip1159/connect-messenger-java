package com.javatraining.springchat.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user1Id, user2Id;

    @OneToMany
    @JoinColumn(name = "conversationId", updatable = false, insertable = false)
    private List<Message> messages;
}
