package com.deliveryMSA.Hubs.domain.hubs.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    HUBS_NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found Hubs"),
    HUBS_ALREADY_EXIST(HttpStatus.CONFLICT, "This Hubs ID is already exists");

    private final HttpStatus httpStatus;
    private final String message;
}