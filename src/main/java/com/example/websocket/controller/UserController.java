package com.example.websocket.controller;

import com.example.websocket.entity.*;
import com.example.websocket.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    @MessageMapping("/addUser")
    @SendTo("/user/public")
    public User addUser(@Payload User user) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/disconnectUser")
    @SendTo("/user/public")
    public User disconnectUser(@Payload User user) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/register")
    public String register(@RequestParam String email) {
        emailService.sendRegistrationEmail(email);
        return "Registration email sent!";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        System.out.println("This for debug: the request for connected user done ");
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
