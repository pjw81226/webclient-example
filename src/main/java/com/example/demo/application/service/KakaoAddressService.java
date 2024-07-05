package com.example.demo.application.service;

import com.example.demo.infrastructure.network.ApiHelper;
import com.example.demo.infrastructure.properties.KakaoAddressProperties;
import com.example.demo.presentation.dto.KakaoAddressRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoAddressService {
    private final KakaoAddressProperties kakaoAddressProperties;
    private final ApiHelper apiHelper;

    public Mono<String> getAddressApi(KakaoAddressRequestDto kakaoAddressRequestDto){
        Map<String, String> params = new HashMap<>();
        params.put("query",kakaoAddressRequestDto.getAddress());
        String url = kakaoAddressProperties.getUrl(); //todo : Dto 검증 예외처리, parameter 한글이 들어갈 때 url에 안담김
        log.info(url);
        return apiHelper.get(url, params, String.class, kakaoAddressProperties.getKey());
    }
}
