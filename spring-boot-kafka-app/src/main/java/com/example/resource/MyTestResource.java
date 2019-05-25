package com.example.resource;

import com.example.User;
import com.example.message.MyTestProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
public class MyTestResource {

    private final MyTestProducer producer;

    @GetMapping
    public void sendUserMessageXml() {
        User user = new User();
        user.setId(BigInteger.ONE);
        user.setName("Byron");

        producer.sendUserMessageXml(user);
    }

}
