package com.javatraining.springchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;
    private long conversationId;
    private long userId;
    private String content;
    private boolean wasRead;
}
