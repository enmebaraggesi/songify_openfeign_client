package com.songify_openfeign_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SongifyOpenfeignClientApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SongifyOpenfeignClientApplication.class, args);
    }
    
}
