package com.songify_openfeign_client.service;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.received.*;
import com.songify_openfeign_client.sent.SongPostedDto;
import com.songify_openfeign_client.sent.SongUpdatedDto;
import org.springframework.http.HttpStatus;
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
    
    public SongUpdatedDto mapSongToSongUpdatedDto(Song newSong) {
        return new SongUpdatedDto(newSong.name(), newSong.artist());
    }
    
    public Song mapSongUpdateReceivedDtoToSong(SongUpdateReceivedDto receivedDto) {
        return new Song(receivedDto.songName(), receivedDto.artist());
    }
    
    public String mapSongPatchedReceivedDtoToString(SongPatchedReceivedDto receivedDto) {
        return receivedDto.message();
    }
    
    public Map<String, HttpStatus> mapSongDeletedReceivedDtoToAnswerMap(SongDeletedReceivedDto receivedDto) {
        return Map.of(receivedDto.message(), receivedDto.status());
    }
}
