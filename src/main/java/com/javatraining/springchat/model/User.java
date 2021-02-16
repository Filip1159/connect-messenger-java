package com.javatraining.springchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username, name, surname, password;

    @OneToMany
    @JoinColumn(name = "participantId")
    private List<Participant> participants;

    @OneToMany
    @JoinColumn(name = "messageId")
    private List<Message> messages;
}