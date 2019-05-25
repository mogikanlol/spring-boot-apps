package com.example.message;

import com.example.Group;
import com.example.User;
import com.example.config.KafkaListenerTest;
import com.example.config.stream.MyStream;
import com.example.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.messaging.support.GenericMessage;

import java.math.BigInteger;

import static org.mockito.Mockito.verify;

@KafkaListenerTest
public class MyTestListenerTest {

    @Autowired
    private MyStream stream;

    @SpyBean
    private MyTestListener listener;

    @Test
    void shouldReceiveMessageJson() throws Exception {
        String message = TestUtils.readResourceAsString("kafka-message/json/message.json");
        MyTestMessage expected = createTestMessage();

        stream.listenTestMessage().send(new GenericMessage<>(message));

        verify(listener).listenTestMessage(expected);

    }

    @Test
    void shouldReceiveUserXml() throws Exception {
        String message = TestUtils.readResourceAsString("kafka-message/xml/user.xml");
        User expected = createUser();

        stream.listenUserXml().send(new GenericMessage<>(message));

        verify(listener).listenUserMessage(expected);
    }

    @Test
    void shouldReceiveGroupXml() throws Exception {
        String message = TestUtils.readResourceAsString("kafka-message/xml/group.xml");
        Group expected = createGroup();

        stream.listenGroupXml().send(new GenericMessage<>(message));

        verify(listener).listenGroupMessage(expected);
    }

    private MyTestMessage createTestMessage() {
        return new MyTestMessage()
                .setContent("content")
                .setId("id");
    }

    private User createUser() {
        User user = new User();
        user.setName("Byron");
        user.setId(BigInteger.ONE);

        return user;
    }

    private Group createGroup() {
        Group group = new Group();
        group.setId(BigInteger.ONE);
        group.setUserCdata("<user/>");

        return group;
    }
}
