package com.example.websocket.repository;

import com.example.websocket.entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    @Query("{$or: [{userAId: ?0, userBId: ?1}, {userAId: ?1, userBId: ?0}]}")
    Optional<ChatRoom> findChatRoomByUsers(String userAId, String userBId);
}