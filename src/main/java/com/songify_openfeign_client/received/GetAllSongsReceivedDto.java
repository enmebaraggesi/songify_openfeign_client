package com.songify_openfeign_client.received;

import com.songify_openfeign_client.client.Song;

import java.util.Map;

public record GetAllSongsReceivedDto(Map<Integer, Song> songs) {

}
