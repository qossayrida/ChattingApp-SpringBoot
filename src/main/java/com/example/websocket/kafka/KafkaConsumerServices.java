package com.example.websocket.kafka;

import com.example.websocket.entity.ChatMessage;
import com.example.websocket.utilities.ChatNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class KafkaConsumerServices {
    private static final String TOPIC = "public-chats";
    private final SimpMessagingTemplate messagingTemplate;
    private final List<ChatMessage> chatMessages = new ArrayList<>();
    public KafkaConsumerServices(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    @KafkaListener(topics = TOPIC, groupId = "my-group")
    public void handleMessage(@Payload ChatMessage message) {
        System.out.println(message);
        log.info("Received message from Kafka: {}", message);
        chatMessages.add(message);
        messagingTemplate.convertAndSendToUser(
                message.getRecipientId(), "/queue/messages",
                new ChatNotification(
                        message.getId(),
                        message.getSenderId(),
                        message.getRecipientId(),
                        message.getContent()
                )
        );
    }

    public List<ChatMessage> getChatMessages() {
        return new ArrayList<>(chatMessages);
    }
}
