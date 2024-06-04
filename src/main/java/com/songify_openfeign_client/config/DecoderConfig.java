package com.songify_openfeign_client.config;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DecoderConfig {
    
    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }
}
