package com.example.config.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyStream {

    @Input("my-topic")
    SubscribableChannel listenTestMessage();

    @Input("my-topic-user")
    SubscribableChannel listenUserXml();

    @Input("my-topic-group")
    SubscribableChannel listenGroupXml();

    @Output("my-topic-user-out")
    MessageChannel produceUserXml();
}
