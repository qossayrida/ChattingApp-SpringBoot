package com.example.websocket.service;


import com.example.websocket.repository.*;
import com.example.websocket.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    @Autowired
    ChatMessageRepository chatMessageRepository;

    @Autowired
    ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        String chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow();
        chatMessage.setChatId(chatId);
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        Optional<String> chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }
}
