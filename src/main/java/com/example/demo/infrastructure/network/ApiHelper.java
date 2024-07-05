package com.example.demo.infrastructure.network;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiHelper {
    private final WebClient webClient;

    public <T> Mono<T> get(String url, Class<T> responseType){
        return webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T> Mono<T> get(String url, Map<String,String> params, Class<T> responseType, String apiKey){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
        if (params != null && !params.isEmpty()) {
            for (var entry : params.entrySet()) {
                uriBuilder.queryParam(entry.getKey(), entry.getValue());
                log.info(entry.getKey() + " " + entry.getValue());
            }
        }
        URI uri = uriBuilder.build().toUri();
        log.info("{}",uri);
        return webClient.method(HttpMethod.GET)
                .uri(uriBuilder.build().toUri())
                .header("Authorization", apiKey)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T, B> Mono<T> post(String url, Class<T> responseType, B body, Map<String, String> header) {
        WebClient.RequestBodySpec requestBodySpec = webClient.method(HttpMethod.POST).uri(url);

        if (header != null && !header.isEmpty()) {
            requestBodySpec.headers(httpHeaders -> {
                for (var entry : header.entrySet()) {
                    String headerName = entry.getKey();
                    String headerValue = entry.getValue();
                    httpHeaders.set(headerName, headerValue);
                    log.info("Setting header: {} = {}", headerName, headerValue);  // Logging the header
                }
            });
        }
        WebClient.ResponseSpec responseSpec = requestBodySpec
                .body(BodyInserters.fromValue(body))
                .retrieve();

        return responseSpec.bodyToMono(responseType).delayElement(Duration.ofSeconds(1));
    }
}
