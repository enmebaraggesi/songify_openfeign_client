package com.songify_openfeign_client.service;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.received.*;
import com.songify_openfeign_client.sent.SongPostedDto;
import com.songify_openfeign_client.sent.SongUpdatedDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Log4j2
@Service
public class SongifyService {
    
    private final SongifyProxy songifyProxy;
    private final SongifyMapper songifyMapper;
    
    public SongifyService(SongifyMapper songifyMapper, SongifyProxy songifyProxy) {
        this.songifyMapper = songifyMapper;
        this.songifyProxy = songifyProxy;
    }
    
    public void getAllSongs() {
        log.info("Getting all songs...");
        GetAllSongsReceivedDto receivedDto = songifyProxy.getAllSongs();
        Map<Integer, Song> songMap = songifyMapper.mapGetAllSongsReceivedDtoToSongsMap(receivedDto);
        logSongMap(songMap);
    }
    
    public void getAllSongsLimited(Integer limit) {
        log.info("Getting all songs limited to {}...", limit);
        GetAllSongsReceivedDto receivedDto = songifyProxy.getAllSongsLimited(limit);
        Map<Integer, Song> songMap = songifyMapper.mapGetAllSongsReceivedDtoToSongsMap(receivedDto);
        logSongMap(songMap);
    }
    
    public void getSongById(Integer id) {
        log.info("Getting song by id {}...", id);
        String requestId = String.valueOf(new Random().nextInt(0, 999));
        SongReceivedDto receivedDto = songifyProxy.getSongById(id, requestId);
        Song receivedSong = songifyMapper.mapSongReceivedDtoToSong(receivedDto);
        log.info("Received song: {}", receivedSong);
    }
    
    public void postNewSong(Song newSong) {
        log.info("Posting new song...");
        SongPostedDto postedDto = songifyMapper.mapSongToSongPostedDto(newSong);
        SongReceivedDto receivedDto = songifyProxy.postNewSong(postedDto);
        Song receivedSong = songifyMapper.mapSongReceivedDtoToSong(receivedDto);
        log.info("New song posted: {}", receivedSong);
    }
    
    public void putSongById(Integer id, Song newSong) {
        log.info("Updating song with id {}...", id);
        SongUpdatedDto postedDto = songifyMapper.mapSongToSongUpdatedDto(newSong);
        SongUpdateReceivedDto receivedDto = songifyProxy.putSongById(id, postedDto);
        Song receivedSong = songifyMapper.mapSongUpdateReceivedDtoToSong(receivedDto);
        log.info("Song updated: {}", receivedSong);
    }
    
    private static void logSongMap(Map<Integer, Song> songMap) {
        songMap.forEach(
                (id, song) -> log.info("ID {}: '{}' of '{}'", id, song.name(), song.artist())
        );
    }
}
