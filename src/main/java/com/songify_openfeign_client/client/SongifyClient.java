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
    
    public void getSongById(Integer id) {
        songifyService.getSongById(id);
    }
    
    public void postNewSong(Song newSong) {
        songifyService.postNewSong(newSong);
    }
    
    public void putSongById(Integer id, Song newSong) {
        songifyService.putSongById(id, newSong);
    }
    
    public void patchSongById(Integer id, Song patch) {
        songifyService.patchSongById(id, patch);
    }
}
