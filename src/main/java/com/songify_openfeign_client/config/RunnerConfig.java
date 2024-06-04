package com.songify_openfeign_client.config;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.client.SongifyClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class RunnerConfig {
    
    @Bean
    CommandLineRunner init(SongifyClient songifyClient) {
        return args -> {
            songifyClient.getAllSongs();
            songifyClient.getAllSongsLimited(3);
            songifyClient.getSongById(2);
            Song newSong = new Song("newSong", "newArtist");
            songifyClient.postNewSong(newSong);
        };
    }
}
