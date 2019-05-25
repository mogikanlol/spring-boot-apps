package com.example.config.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MyStream {

    @Input("my-topic")
    SubscribableChannel listenTestMessage();

    @Input("my-topic-user")
    SubscribableChannel listenUserXsd();

    @Input("my-topic-group")
    SubscribableChannel listenGroupXsd();

}
