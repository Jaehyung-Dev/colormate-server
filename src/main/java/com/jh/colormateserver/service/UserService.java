package com.jh.colormateserver.service;

import com.jh.colormateserver.dto.JoinDto;
import com.jh.colormateserver.entity.User;
import com.jh.colormateserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(JoinDto joinDto) {
        String email = joinDto.getEmail();
        String password = joinDto.getPassword();
        String nickname = joinDto.getNickname();

        Boolean isExist = userRepository.existsByEmail(email);

        if(isExist) {

        }

        User user = new User();

        user.setEmail(email);
        user.setNickname(nickname);
        if (joinDto.getPassword() == null) {
            throw new IllegalArgumentException("비밀번호가 null입니다.");
        }
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
    }
}
