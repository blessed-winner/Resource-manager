package com.xenon.Resource_manager;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Resource {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate(){
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
