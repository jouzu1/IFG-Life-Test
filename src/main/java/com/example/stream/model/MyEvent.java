package com.example.stream.model;

import java.time.Instant;

public class MyEvent {
    private String id;
    private String payload;
    private Instant processedAt;

    public MyEvent() {}

    public MyEvent(String id, String payload, Instant processedAt) {
        this.id = id;
        this.payload = payload;
        this.processedAt = processedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Instant getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Instant processedAt) {
        this.processedAt = processedAt;
    }
}
