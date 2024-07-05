package com.example.demo.presentation.controller;

import com.example.demo.application.service.KakaoService;
import com.example.demo.presentation.dto.KakaoSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;

    @GetMapping("/web")
    public Mono<String> searchWeb(@RequestBody KakaoSearchRequestDto kakaoSearchRequestDto) {
        return kakaoService.getSearchWebApiKakao(kakaoSearchRequestDto);
    }

    @GetMapping("/blog")
    public Mono<String> searchBlog(@RequestBody KakaoSearchRequestDto kakaoSearchRequestDto) {
        return kakaoService.getSearchBlogApiKakao(kakaoSearchRequestDto);
    }

}
