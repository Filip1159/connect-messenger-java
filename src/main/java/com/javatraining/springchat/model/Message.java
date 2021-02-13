package com.javatraining.springchat.model;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sender, text;
    private boolean read;


}
