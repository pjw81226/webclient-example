package com.example.demo.application.service;

import com.example.demo.infrastructure.network.ApiHelper;
import com.example.demo.infrastructure.properties.KakaoBlogProperties;
import com.example.demo.infrastructure.properties.KakaoWebProperties;
import com.example.demo.presentation.dto.KakaoSearchRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoService {
    private final ApiHelper apiHelper;
    private final KakaoBlogProperties kakaoBlogProperties;
    private final KakaoWebProperties kakaoWebProperties;

    public Mono<String> getSearchWebApiKakao(KakaoSearchRequestDto kakaoSearchRequestDto){
        String url =kakaoWebProperties.getUrl();
        Map<String, String> params = new HashMap<>();
        params.put("query", kakaoSearchRequestDto.getQuery());
        return apiHelper.get(url,params, String.class, kakaoWebProperties.getKey());  //todo : Dto 검증 예외처리, 중복제거
    }
    public Mono<String> getSearchBlogApiKakao(KakaoSearchRequestDto kakaoSearchRequestDto){
        String url = kakaoBlogProperties.getUrl();
        Map<String, String> params = new HashMap<>();
        params.put("query", kakaoSearchRequestDto.getQuery());
        return apiHelper.get(url, params, String.class, kakaoBlogProperties.getKey());  //todo : Dto 검증 예외처리, 중복제거
    }
}
