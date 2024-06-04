package com.songify_openfeign_client.client;

import com.songify_openfeign_client.service.SongifyService;
import org.springframework.stereotype.Component;

@Component
public class SongifyClient {
    
    private final SongifyService songifyService;
    
    public SongifyClient(SongifyService songifyService) {
        this.songifyService = songifyService;
    }
    
    public void getAllSongs() {
        songifyService.getAllSongs();
    }
    
    public void getAllSongsLimited(Integer limit) {
        songifyService.getAllSongsLimited(limit);
    }
    
    public void postNewSong(Song newSong) {
        songifyService.postNewSong(newSong);
    }
}
