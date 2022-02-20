package connect.messenger.controller;

import connect.messenger.model.User;
import connect.messenger.model.dto.UserDto;
import connect.messenger.model.dto.UserDtoMapper;
import connect.messenger.service.UserService;
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
