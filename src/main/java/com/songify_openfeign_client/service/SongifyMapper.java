package com.songify_openfeign_client.service;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.received.*;
import com.songify_openfeign_client.requested.SongToPostRequestDto;
import com.songify_openfeign_client.requested.SongToUpdatedRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class SongifyMapper {
    
    public Map<Integer, Song> mapGetAllSongsReceivedDtoToSongsMap(GetAllSongsReceivedDto receivedDto) {
        return receivedDto.songs();
    }
    
    public SongToPostRequestDto mapSongToSongPostedDto(Song newSong) {
        return new SongToPostRequestDto(newSong.name(), newSong.artist());
    }
    
    public Song mapSongReceivedDtoToSong(GetSongReceivedDto receivedDto) {
        return receivedDto.song();
    }
    
    public SongToUpdatedRequestDto mapSongToSongUpdatedDto(Song newSong) {
        return new SongToUpdatedRequestDto(newSong.name(), newSong.artist());
    }
    
    public Song mapSongUpdateReceivedDtoToSong(UpdateSongReceivedDto receivedDto) {
        return new Song(receivedDto.songName(), receivedDto.artist());
    }
    
    public String mapSongPatchedReceivedDtoToString(PatchSongReceivedDto receivedDto) {
        return receivedDto.message();
    }
    
    public Map<String, HttpStatus> mapSongDeletedReceivedDtoToAnswerMap(DeleteSongReceivedDto receivedDto) {
        return Map.of(receivedDto.message(), receivedDto.status());
    }
}
