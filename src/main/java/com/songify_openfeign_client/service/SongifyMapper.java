package com.songify_openfeign_client.service;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.received.GetAllSongsReceivedDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SongifyMapper {
    
    public Map<Integer, Song> mapGetAllSongsReceivedDtoToSongsMap(GetAllSongsReceivedDto receivedDto) {
        return receivedDto.songs();
    }
}
