package com.songify_openfeign_client.service;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.received.GetAllSongsReceivedDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SongifyService {
    
    private final SongifyProxy songifyProxy;
    private final SongifyMapper songifyMapper;
    
    public SongifyService(SongifyMapper songifyMapper, SongifyProxy songifyProxy) {
        this.songifyMapper = songifyMapper;
        this.songifyProxy = songifyProxy;
    }
    
    public Map<Integer, Song> getAllSongs() {
        GetAllSongsReceivedDto receivedDto = songifyProxy.getAllSongs();
        return songifyMapper.mapGetAllSongsReceivedDtoToSongsMap(receivedDto);
    }
    
    public Map<Integer, Song> getAllSongsLimited(Integer limit) {
        GetAllSongsReceivedDto receivedDto = songifyProxy.getAllSongsLimited(limit);
        return songifyMapper.mapGetAllSongsReceivedDtoToSongsMap(receivedDto);
    }
}
