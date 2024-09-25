package com.deliveryMSA.Hubs.domain.hubs.exception;

import com.deliveryMSA.Hubs.domain.hubs.message.ExceptionMessage;
import org.springframework.http.HttpStatus;

public class HubsException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;

    public HubsException(ExceptionMessage exceptionMessage) {
        super("[Hubs Exception] : " + exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public HttpStatus getHttpStatus() {

        return exceptionMessage.getHttpStatus();
    }

    public String getMessage() {

        return exceptionMessage.getMessage();
    }
}
