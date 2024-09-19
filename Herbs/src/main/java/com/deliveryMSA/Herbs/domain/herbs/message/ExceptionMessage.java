package com.deliveryMSA.Herbs.domain.herbs.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    HERBS_NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found Herbs");

    private final HttpStatus httpStatus;
    private final String message;
}