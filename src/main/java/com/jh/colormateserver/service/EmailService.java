package com.jh.colormateserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    private final ConcurrentHashMap<String, String> authCodeMap = new ConcurrentHashMap<>();

    public void sendAuthCode(String email) {
        String code = String.valueOf((int) (Math.random() * 900000) + 100000);
        
        // 임시 메모리저장 추후 redis 교체 필요
        authCodeMap.put(email, code);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Colormate 인증번호입니다.");
        message.setText("인증번호: " + code);

        mailSender.send(message);
    }

    public boolean verifyCode(String email, String code) {
        String stored = authCodeMap.get(email);
        return code.equals(stored);
    }
}
