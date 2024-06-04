package com.songify_openfeign_client.config;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpConfig {
    
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
