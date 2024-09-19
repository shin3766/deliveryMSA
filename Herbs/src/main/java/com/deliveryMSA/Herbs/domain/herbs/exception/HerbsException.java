package com.deliveryMSA.Herbs.domain.herbs.exception;

import com.deliveryMSA.Herbs.domain.herbs.message.ExceptionMessage;
import com.deliveryMSA.Herbs.global.message.ExceptionResponse;
import org.springframework.http.HttpStatus;

public class HerbsException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;

    public HerbsException(ExceptionMessage exceptionMessage) {
        super("[Herbs Exception] : " + exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public HttpStatus getHttpStatus() {

        return exceptionMessage.getHttpStatus();
    }

    public String getMessage() {

        return exceptionMessage.getMessage();
    }
}
