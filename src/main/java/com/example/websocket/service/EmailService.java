package com.example.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendRegistrationEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@yourdomain.com");
        message.setTo(to);
        message.setSubject("New User Registration");
        message.setText("Your registration code is: " + generateVerificationCode());
        emailSender.send(message);
    }

    public String generateVerificationCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }
}
