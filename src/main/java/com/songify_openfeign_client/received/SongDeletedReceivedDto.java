package com.songify_openfeign_client.received;

import org.springframework.http.HttpStatus;

public record SongDeletedReceivedDto(String message, HttpStatus status) {

}
