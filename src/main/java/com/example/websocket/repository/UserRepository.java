package com.example.websocket.repository;

import com.example.websocket.entity.*;
import com.example.websocket.utilities.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}

