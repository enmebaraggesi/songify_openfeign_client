package com.songify_openfeign_client.client;

import com.songify_openfeign_client.service.SongifyService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SongifyClient {
    
    private final SongifyService songifyService;
    
    public SongifyClient(SongifyService songifyService) {
        this.songifyService = songifyService;
    }
    
    public Map<Integer, Song> getAllSongs() {
        return songifyService.getAllSongs();
    }
}
