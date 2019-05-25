package com.example.config.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableBinding({
        MyStream.class
})
public class StreamConfiguration {

    /**
     * org.springframework.cloud.stream.config.ContentTypeConfiguration
     * org.springframework.cloud.stream.converter.CompositeMessageConverterFactory - registers custom message converters
     */
    @Bean
    @StreamMessageConverter
    public XmlMessageConverter xmlMessageConverter(Jaxb2Marshaller jaxb2Marshaller) {
        return new XmlMessageConverter(jaxb2Marshaller);
    }

}
