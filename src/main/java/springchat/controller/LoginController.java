package springchat.controller;

import springchat.config.LoginCredentials;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @PostMapping("")
    public void login(@RequestBody LoginCredentials credentials) {
        System.out.println("Called login method");
    }
}
