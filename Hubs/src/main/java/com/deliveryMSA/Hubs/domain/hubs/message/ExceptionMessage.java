package com.deliveryMSA.Hubs.domain.hubs.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    HERBS_NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found Herbs");

    private final HttpStatus httpStatus;
    private final String message;
}