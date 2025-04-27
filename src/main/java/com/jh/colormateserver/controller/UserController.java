package com.jh.colormateserver.controller;

import com.jh.colormateserver.entity.User;
import com.jh.colormateserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public User SignUp(@RequestBody User user) {
        return userRepository.save(user);
    }
}
