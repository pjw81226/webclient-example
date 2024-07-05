package com.example.demo.presentation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
public class OpenaiAskRequestDto {
    private String model;
    private List<Message> messages;
    @Data
    @RequiredArgsConstructor
    private static class Message {
        private final String role;
        private final String content;
    }
}
