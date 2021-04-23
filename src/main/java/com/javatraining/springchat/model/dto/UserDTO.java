package com.javatraining.springchat.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private long userId;
    private String name, surname, username;
}
