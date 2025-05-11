package com.jh.colormateserver.controller;

import com.jh.colormateserver.dto.JoinDto;
import com.jh.colormateserver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String SignUp(@RequestBody JoinDto joinDto) {
        userService.join(joinDto);
        return "ok";
    }
}
