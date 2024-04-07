package com.example.websocket.controller;

import com.example.websocket.entity.ChatMessage;
import com.example.websocket.kafka.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@Slf4j
public class WebSocketController {

//    @Autowired
//    KafkaProducerServices kafkaProducerServices;
//
//    @Autowired
//    KafkaConsumerServices kafkaConsumerServices;
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public void handleChatMessage(@Payload ChatMessage message) {
//        kafkaProducerServices.sendMessage(message);
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public void addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor){
//        log.info("User added: {}", message.getSenderId());
//        if (headerAccessor != null && headerAccessor.getSessionAttributes() != null) {
//            headerAccessor.getSessionAttributes().put("username", message.getSenderId());
//        } else {
//            log.error("headerAccessor or session attributes is null.");
//        }
//        kafkaProducerServices.sendMessage(message);
//    }
//
//    @MessageMapping("/chat.removeUser")
//    @SendTo("/topic/public")
//    public void removeUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
//        log.info("User disconnected: {}", message.getSenderId());
//        kafkaProducerServices.sendMessage(message);
//        if (headerAccessor != null && headerAccessor.getSessionAttributes() != null) {
//            headerAccessor.getSessionAttributes().remove("username");
//        } else {
//            log.error("headerAccessor or session attributes is null.");
//        }
//    }
//
//    @GetMapping("/api/chat")
//    public List<ChatMessage> getChatMessages() {
//        return kafkaConsumerServices.getChatMessages();
//    }

}