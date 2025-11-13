package com.likelion.assignment14.global.config;

import org.springframework.boot.web.client.RestTemplateBuilder; // Builder 임포트
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter; // 인코딩 설정용 임포트
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets; // UTF-8 설정용 임포트

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                // String 응답을 받을 때 강제로 UTF-8 인코딩을 사용하도록 설정
                .additionalMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8))
                .build();
    }
}