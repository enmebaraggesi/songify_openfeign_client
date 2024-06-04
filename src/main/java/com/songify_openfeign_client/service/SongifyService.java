package com.songify_openfeign_client.service;

import com.songify_openfeign_client.client.Song;
import com.songify_openfeign_client.received.*;
import com.songify_openfeign_client.requested.SongToPostRequestDto;
import com.songify_openfeign_client.requested.SongToUpdatedRequestDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Log4j2
@Service
public class SongifyService {
    
    private final SongifyProxy songifyProxy;
    private final SongifyMapper songifyMapper;
    
    SongifyService(SongifyMapper songifyMapper, SongifyProxy songifyProxy) {
        this.songifyMapper = songifyMapper;
        this.songifyProxy = songifyProxy;
    }
    
    public void getAllSongs() {
        log.info("Getting all songs...");
        GetAllSongsReceivedDto receivedDto = songifyProxy.getAllSongs();
        Map<Integer, Song> songMap = songifyMapper.mapGetAllSongsReceivedDtoToSongsMap(receivedDto);
        songsReceivedLog(songMap);
    }
    
    public void getAllSongsLimited(Integer limit) {
        log.info("Getting all songs limited to {}...", limit);
        GetAllSongsReceivedDto receivedDto = songifyProxy.getAllSongsLimited(limit);
        Map<Integer, Song> songMap = songifyMapper.mapGetAllSongsReceivedDtoToSongsMap(receivedDto);
        songsReceivedLog(songMap);
    }
    
    public void getSongById(Integer id) {
        log.info("Getting song by id {}...", id);
        String requestId = String.valueOf(new Random().nextInt(0, 999));
        GetSongReceivedDto receivedDto = songifyProxy.getSongById(id, requestId);
        Song receivedSong = songifyMapper.mapSongReceivedDtoToSong(receivedDto);
        log.info("Received song: {}", receivedSong);
    }
    
    public void postNewSong(Song newSong) {
        log.info("Posting new song...");
        SongToPostRequestDto postedDto = songifyMapper.mapSongToSongPostedDto(newSong);
        GetSongReceivedDto receivedDto = songifyProxy.postNewSong(postedDto);
        Song receivedSong = songifyMapper.mapSongReceivedDtoToSong(receivedDto);
        log.info("New song posted: {}", receivedSong);
    }
    
    public void putSongById(Integer id, Song newSong) {
        log.info("Updating song with id {}...", id);
        SongToUpdatedRequestDto putDto = songifyMapper.mapSongToSongUpdatedDto(newSong);
        UpdateSongReceivedDto receivedDto = songifyProxy.putSongById(id, putDto);
        Song receivedSong = songifyMapper.mapSongUpdateReceivedDtoToSong(receivedDto);
        log.info("Song updated: {}", receivedSong);
    }
    
    public void patchSongById(Integer id, Song patch) {
        log.info("Patching song with id {}...", id);
        SongToUpdatedRequestDto postedDto = songifyMapper.mapSongToSongUpdatedDto(patch);
        PatchSongReceivedDto receivedDto = songifyProxy.patchSongById(id, postedDto);
        String message = songifyMapper.mapSongPatchedReceivedDtoToString(receivedDto);
        log.info("Song patched: {}", message);
    }
    
    public void deleteSongById(Integer id) {
        log.info("Deleting song by id {}...", id);
        DeleteSongReceivedDto receivedDto = songifyProxy.deleteSongById(id);
        Map<String, HttpStatus> receivedAnswer = songifyMapper.mapSongDeletedReceivedDtoToAnswerMap(receivedDto);
        deletedSongAnswerLog(receivedAnswer);
    }
    
    private static void songsReceivedLog(Map<Integer, Song> songMap) {
        songMap.forEach(
                (id, song) -> log.info("ID {}: '{}' of '{}'", id, song.name(), song.artist())
        );
    }
    
    private static void deletedSongAnswerLog(Map<String, HttpStatus> receivedAnswer) {
        receivedAnswer.forEach(
                (message, status) -> log.info("Received answer: {}, with status: {}", message, status)
        );
    }
}
