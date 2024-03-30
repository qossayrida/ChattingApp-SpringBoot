package com.example.websocket.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.websocket.entity.*;
import com.example.websocket.repository.*;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    @Autowired
    ChatRoomRepository chatRoomRepository;
    public Optional<String> getChatRoomId(String userAId, String userBId, boolean createNewRoomIfNotExists){
        return chatRoomRepository
                .findChatRoomByUsers(userAId, userBId)
                .map(ChatRoom::getId)
                .or(() -> {
                    if(createNewRoomIfNotExists) {
                        return createChatRoom(userAId, userBId);
                    }
                    return  Optional.empty();
                });
    }

    private Optional<String> createChatRoom(String userAId, String userBId) {
        ChatRoom senderRecipient = ChatRoom
                .builder()
                .userAId(userAId)
                .userBId(userBId)
                .creationDate(new Date())
                .build();

        chatRoomRepository.save(senderRecipient);

        return chatRoomRepository
                .findChatRoomByUsers(userAId, userBId)
                .map(ChatRoom::getId);
    }
}
