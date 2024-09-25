package com.deliveryMSA.Hub.domain.hub.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    Hub_NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found Hub"),
    Hub_ALREADY_EXIST(HttpStatus.CONFLICT, "This Hub ID is already exists");

    private final HttpStatus httpStatus;
    private final String message;
}