package com.songify_openfeign_client.service;

import com.songify_openfeign_client.received.*;
import com.songify_openfeign_client.sent.SongPostedDto;
import com.songify_openfeign_client.sent.SongUpdatedDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify-client", url = "http://localhost:8080/songs")
public interface SongifyProxy {
    
    @GetMapping
    GetAllSongsReceivedDto getAllSongs();
    
    @GetMapping
    GetAllSongsReceivedDto getAllSongsLimited(@RequestParam Integer limit);
    
    @GetMapping("{id}")
    SongReceivedDto getSongById(@PathVariable Integer id, @RequestHeader String requestId);
    
    @PostMapping
    SongReceivedDto postNewSong(@RequestBody SongPostedDto postedDto);
    
    @PutMapping("{id}")
    SongUpdateReceivedDto putSongById(@PathVariable Integer id, @RequestBody SongUpdatedDto postedDto);
    
    @PatchMapping("{id}")
    SongPatchedReceivedDto patchSongById(@PathVariable Integer id, @RequestBody SongUpdatedDto postedDto);
    
    @DeleteMapping("{id}")
    SongDeletedReceivedDto deleteSongById(@PathVariable Integer id);
}
