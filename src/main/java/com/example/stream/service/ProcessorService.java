package com.example.stream.service;

import com.example.stream.db.ProcessedRecord;
import com.example.stream.db.ProcessedRecordRepository;
import com.example.stream.model.MyEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.time.Instant;

@ApplicationScoped
public class ProcessorService {
    @Inject
    ObjectMapper objectMapper;

    @Inject
    ProcessedRecordRepository repository;

    @Channel("processed")
    @Inject
    Emitter<String> processedEmitter;

    @ConfigProperty(name = "app.output.mode", defaultValue = "kafka")
    String outputMode;

    public MyEvent transform(MyEvent input) {
        MyEvent out = new MyEvent();
        out.setId(input.getId());
        out.setPayload(input.getPayload() == null ? null : input.getPayload().toUpperCase());
        out.setProcessedAt(Instant.now());
        return out;
    }

    @Incoming("input")
    public void consume(String message) throws Exception {
        MyEvent input = objectMapper.readValue(message, MyEvent.class);
        MyEvent transformed = transform(input);
        if ("kafka".equalsIgnoreCase(outputMode)) {
            processedEmitter.send(objectMapper.writeValueAsString(transformed));
        } else {
            ProcessedRecord record = new ProcessedRecord();
            record.eventId = transformed.getId();
            record.payload = transformed.getPayload();
            record.processedAt = transformed.getProcessedAt();
            repository.persist(record);
        }
    }
}
