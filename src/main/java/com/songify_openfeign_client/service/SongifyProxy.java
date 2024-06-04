package com.songify_openfeign_client.service;

import com.songify_openfeign_client.received.GetAllSongsReceivedDto;
import com.songify_openfeign_client.received.SongReceivedDto;
import com.songify_openfeign_client.sent.SongPostedDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify-client", url = "http://localhost:8080/songs")
public interface SongifyProxy {
    
    @GetMapping
    GetAllSongsReceivedDto getAllSongs();
    
    @GetMapping
    GetAllSongsReceivedDto getAllSongsLimited(@RequestParam Integer limit);
    
    @PostMapping
    SongReceivedDto postNewSong(@RequestBody SongPostedDto postedDto);
}
