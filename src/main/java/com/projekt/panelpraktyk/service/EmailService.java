package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.models.VerificationToken;
import com.projekt.panelpraktyk.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final TokenRepository tokenRepository;

    public void sendVerificationLink(String email) {
        String token = UUID.randomUUID().toString();

        VerificationToken vToken = new VerificationToken();
        vToken.setToken(token);
        vToken.setEmail(email);
        vToken.setExpiryDate(LocalDateTime.now().plusHours(24));
        tokenRepository.save(vToken);

        String link = "http://localhost:8080/verify?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("link do Panelu Praktyk");
        message.setText("Kliknij tutaj: " + link);

        mailSender.send(message);
    }
}