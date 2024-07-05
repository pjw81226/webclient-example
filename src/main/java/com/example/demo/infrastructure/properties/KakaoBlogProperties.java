package com.example.demo.infrastructure.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KakaoBlogProperties extends KakaoProperties{
    @Value("${kakao.api.blog.url}")
    private String url;
}
