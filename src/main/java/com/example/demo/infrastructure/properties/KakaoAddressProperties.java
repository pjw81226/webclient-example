package com.example.demo.infrastructure.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KakaoAddressProperties extends KakaoProperties{
    @Value("${kakao.api.address.url}")
    private String url;
}
