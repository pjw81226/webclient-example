package com.example.demo.presentation.controller;

import com.example.demo.application.service.OpenAiService;
import com.example.demo.presentation.dto.OpenaiAskRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class OpenAiController {
    private final OpenAiService openAiService;

    @PostMapping("/ask")
    public Mono<String> askOpenAi(@RequestBody OpenaiAskRequestDto openaiAskRequestDto){
        log.info("Controller");
        return openAiService.getResponseApiOpenai(openaiAskRequestDto);
    }
}
