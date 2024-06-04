package com.songify_openfeign_client.received;

import org.springframework.http.HttpStatus;

public record DeleteSongReceivedDto(String message, HttpStatus status) {

}
