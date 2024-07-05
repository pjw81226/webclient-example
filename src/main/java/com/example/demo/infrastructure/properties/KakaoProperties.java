package com.example.demo.infrastructure.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Component
public class KakaoProperties {
    @Value("${kakao.api.key}")
    private String key;
}
