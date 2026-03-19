package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.repository.TokenRepository;
import com.projekt.panelpraktyk.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;
    private final TokenRepository tokenRepository;

    @GetMapping("/wyslij")
    public String send(@RequestParam String email) {
        emailService.sendVerificationLink(email);
        return "Poszło na: " + email;
    }

    @GetMapping("/weryfikuj")
    public String verifyToken(@RequestParam String token) {
        return tokenRepository.findByToken(token)
                .map(t -> {

                    return "Link działa. Token " + t.getToken() + " znaleziony w bazie.";
                })
                .orElse("Błąd: Nie znaleziono takiego tokenu w bazie danych.");
    }
}