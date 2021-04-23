package com.javatraining.springchat.model.dto;

import com.javatraining.springchat.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {
    private UserDtoMapper() {}
    public static List<UserDTO> mapToUserDTOs(List<User> users) {
        return users.stream()
                .map(UserDtoMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    private static UserDTO mapToUserDTO(User u) {
        return UserDTO.builder()
                .userId(u.getUserId())
                .name(u.getName())
                .surname(u.getSurname())
                .username(u.getUsername())
                .build();
    }
}
