package com.example.demo.presentation.controller;

import com.example.demo.application.service.KakaoAddressService;
import com.example.demo.presentation.dto.KakaoAddressRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoAddressController {
    private final KakaoAddressService kakaoAddressService;

    @GetMapping("/address")
    public Mono<String> searchAddress(@RequestBody KakaoAddressRequestDto kakaoAddrressRequestDto){
        return kakaoAddressService.getAddressApi(kakaoAddrressRequestDto);
    }
}
