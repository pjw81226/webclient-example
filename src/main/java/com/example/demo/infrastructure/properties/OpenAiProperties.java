package com.example.demo.infrastructure.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OpenAiProperties {
    private final String url;
    private final String key;

    OpenAiProperties(
            @Value("${openai.api.ask.url}") String url,
            @Value("${openai.api.ask.key}") String key
    ){
        this.url = url;
        this.key = key;
    }
}
