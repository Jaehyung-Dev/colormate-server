package com.jh.colormateserver.controller;

import com.jh.colormateserver.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/verify")
    public ResponseEntity<?> sendCode(@RequestBody Map<String, String> req) {
        emailService.sendAuthCode(req.get("email"));
        return ResponseEntity.ok("인증번호 발송");
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> checkCode(@RequestBody Map<String, String> req) {
        boolean result = emailService.verifyCode(req.get("email"), req.get("code"));
        return result ? ResponseEntity.ok("성공") : ResponseEntity.status(400).body("실패");
    }
}
