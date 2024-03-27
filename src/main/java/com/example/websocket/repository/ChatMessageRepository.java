package com.example.websocket.repository;

import com.example.websocket.entity.*;
import org.springframework.data.mongodb.repository.*;

import java.util.*;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);
}