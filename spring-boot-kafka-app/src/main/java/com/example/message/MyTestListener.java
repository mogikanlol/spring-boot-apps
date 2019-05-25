package com.example.message;

import com.example.Group;
import com.example.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Slf4j
@Component
public class MyTestListener {

    @StreamListener("my-topic")
    public void listenTestMessage(@Valid MyTestMessage message) {

        log.info("Received message = {}", message);
    }

    @StreamListener("my-topic-group")
    public void listenGroupMessage(Group message) {

        log.info("Received message = {}", message);
    }

    @StreamListener("my-topic-user")
    public void listenUserMessage(User message) {

        log.info("Received message = {}", message);
    }
}
