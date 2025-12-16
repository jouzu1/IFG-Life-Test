package com.example.stream.service;

import com.example.stream.model.MyEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.memory.InMemoryConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ProcessorServiceTest {
    @Inject
    ProcessorService service;
    @Inject
    ObjectMapper mapper;
    @Inject
    InMemoryConnector inMemoryConnector;

    @BeforeEach
    void setup() {
        InMemoryConnector.clear();
        InMemoryConnector.switchIncomingChannelsToInMemory("input");
        InMemoryConnector.switchOutgoingChannelsToInMemory("processed");
    }

    @Test
    void transformUppercasesPayloadAndSetsTimestamp() {
        MyEvent in = new MyEvent("1", "abc", null);
        MyEvent out = service.transform(in);
        assertThat(out.getId()).isEqualTo("1");
        assertThat(out.getPayload()).isEqualTo("ABC");
        assertThat(out.getProcessedAt()).isNotNull();
        assertThat(out.getProcessedAt()).isAfter(Instant.now().minusSeconds(5));
    }

    @Test
    void pipelineSendsToProcessedChannel() throws Exception {
        String json = mapper.writeValueAsString(new MyEvent("2", "hello", null));
        var sent = inMemoryConnector.sink("processed").received();
        assertThat(sent).isNotEmpty();
        String payload = (String) sent.get(0).getPayload();
        MyEvent out = mapper.readValue(payload, MyEvent.class);
        assertThat(out.getId()).isEqualTo("2");
        assertThat(out.getPayload()).isEqualTo("HELLO");
        assertThat(out.getProcessedAt()).isNotNull();
    }
}
