package com.example.websocket.repository;

import com.example.websocket.entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}

