package com.example.demo.application.service;


import com.example.demo.infrastructure.network.ApiHelper;
import com.example.demo.infrastructure.properties.OpenAiProperties;
import com.example.demo.presentation.dto.OpenaiAskRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiService {
    private final ApiHelper apiHelper;
    private final OpenAiProperties openAiProperties;

    public Mono<String> getResponseApiOpenai(OpenaiAskRequestDto openaiAskRequestDto){
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + openAiProperties.getKey());
        headers.put("Content-Type", "application/json");
        log.info("Service");
        return apiHelper.post(openAiProperties.getUrl(),String.class, openaiAskRequestDto, headers);
    }
}
//        Map<String, Object> requestBody =new HashMap<>();
//        requestBody.put("model", "gpt-3.5-turbo"); // 사용 가능한 모델 중 하나를 명시
//        requestBody.put("messages", List.of(Map.of("role", "user", "content", prompt))); // GPT-3.5-turbo 모델에서 사용하는 형식
//        requestBody.put("max_tokens", 50);
//
//
//        return webClient
//                .method(HttpMethod.POST)
//                .uri("/chat/completions")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(requestBody))
//                .retrieve()
//                .bodyToMono(String.class);