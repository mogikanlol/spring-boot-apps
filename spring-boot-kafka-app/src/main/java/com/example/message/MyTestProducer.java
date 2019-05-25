package com.example.message;

import com.example.User;
import com.example.config.stream.MyStream;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MimeTypeUtils;

import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class MyTestProducer {

    private final MyStream stream;

    @Transactional
    public void sendUserMessageXml(User user) {
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_XML)
                .build();

        stream.produceUserXml().send(message);

        if (ThreadLocalRandom.current().nextBoolean())
            throw new RuntimeException();
    }

}
