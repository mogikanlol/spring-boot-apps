package com.example.config.stream;

import com.example.MyObject;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.MimeType;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class XmlMessageConverter extends AbstractMessageConverter {

    private Jaxb2Marshaller marshaller;

    protected XmlMessageConverter(Jaxb2Marshaller jaxb2Marshaller) {
        super(new MimeType("application", "xml"));
        this.marshaller = jaxb2Marshaller;
    }


    @Override
    protected boolean supports(Class<?> aClass) {
        Class<MyObject> requestClass = MyObject.class;
        return requestClass.isAssignableFrom(aClass);
    }

    @Override
    protected Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
        Object payload = message.getPayload();
        String str = (String) payload;
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Object unmarshal = marshaller.unmarshal(new StreamSource(bais));

//        Object cast = targetClass.cast(unmarshal);

        return unmarshal;
    }

    @Override
    protected Object convertToInternal(Object payload, MessageHeaders headers, Object conversionHint) {
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);

        marshaller.marshal(payload, result);

        return sw.toString().getBytes();
    }


}
