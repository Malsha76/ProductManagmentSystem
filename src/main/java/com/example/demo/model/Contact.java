package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "contacts")
@Data
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();
}
