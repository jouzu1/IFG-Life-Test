package com.example.stream.db;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class ProcessedRecord extends PanacheEntity {
    @Column(nullable = false)
    public String eventId;
    @Column(nullable = false, length = 2048)
    public String payload;
    @Column(nullable = false)
    public java.time.Instant processedAt;
}
