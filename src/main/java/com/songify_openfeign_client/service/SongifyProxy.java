package com.songify_openfeign_client.service;

import com.songify_openfeign_client.received.*;
import com.songify_openfeign_client.requested.SongToPostRequestDto;
import com.songify_openfeign_client.requested.SongToUpdatedRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify-proxy", url = "${com.songify.url}")
interface SongifyProxy {
    
    @GetMapping
    GetAllSongsReceivedDto getAllSongs();
    
    @GetMapping
    GetAllSongsReceivedDto getAllSongsLimited(@RequestParam Integer limit);
    
    @GetMapping("{id}")
    GetSongReceivedDto getSongById(@PathVariable Integer id, @RequestHeader String requestId);
    
    @PostMapping
    GetSongReceivedDto postNewSong(@RequestBody SongToPostRequestDto postedDto);
    
    @PutMapping("{id}")
    UpdateSongReceivedDto putSongById(@PathVariable Integer id, @RequestBody SongToUpdatedRequestDto postedDto);
    
    @PatchMapping("{id}")
    PatchSongReceivedDto patchSongById(@PathVariable Integer id, @RequestBody SongToUpdatedRequestDto postedDto);
    
    @DeleteMapping("{id}")
    DeleteSongReceivedDto deleteSongById(@PathVariable Integer id);
}
