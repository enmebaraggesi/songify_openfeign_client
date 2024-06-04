package com.songify_openfeign_client.service;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.received.GetAllSongsReceivedDto;
import com.songify_openfeign_client.received.SongReceivedDto;
import com.songify_openfeign_client.sent.SongPostedDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SongifyMapper {
    
    public Map<Integer, Song> mapGetAllSongsReceivedDtoToSongsMap(GetAllSongsReceivedDto receivedDto) {
        return receivedDto.songs();
    }
    
    public SongPostedDto mapSongToSongPostedDto(Song newSong) {
        return new SongPostedDto(newSong.name(), newSong.artist());
    }
    
    public Song mapSongReceivedDtoToSong(SongReceivedDto receivedDto) {
        return receivedDto.song();
    }
}
