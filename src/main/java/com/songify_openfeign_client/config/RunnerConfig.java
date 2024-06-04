package com.songify_openfeign_client.config;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.client.SongifyClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Log4j2
@Configuration
public class RunnerConfig {
    
    @Bean
    CommandLineRunner init(SongifyClient songifyClient) {
        return args -> {
            Map<Integer, Song> allSongs = songifyClient.getAllSongs();
            allSongs.forEach(
                    RunnerConfig::getInformed
            );
            Map<Integer, Song> allSongsLimited = songifyClient.getAllSongsLimited(3);
            allSongsLimited.forEach(
                    RunnerConfig::getInformed
            );
        };
    }
    
    private static void getInformed(Integer id, Song song) {
        log.info("ID {}: '{}' of '{}'", id, song.name(), song.artist());
    }
}
