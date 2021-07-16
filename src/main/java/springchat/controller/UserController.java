package springchat.controller;

import springchat.model.User;
import springchat.model.dto.UserDto;
import springchat.model.dto.UserDtoMapper;
import springchat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{text}")
    public List<UserDto> getUsersByQuery(@PathVariable String text) {
        List<User> users = userService.getUsersByQuery(text);
        return UserDtoMapper.mapToUserDtos(users);

    }
}
