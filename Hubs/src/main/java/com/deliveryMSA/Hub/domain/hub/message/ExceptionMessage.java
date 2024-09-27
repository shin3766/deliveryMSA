package com.deliveryMSA.Hub.domain.hub.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {

    HUB_NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found Hub"),
    HUB_ALREADY_EXIST(HttpStatus.CONFLICT, "This Hub ID is already exists"),
    HUB_INVALID_ADDRESS(HttpStatus.BAD_REQUEST, "주소가 잘못됐습니다."),
    HUB_INVALID_HUB_NAME(HttpStatus.BAD_REQUEST, "허브 이름이 잘못됐습니다."),
    HUB_INVALID_COORDINATE(HttpStatus.BAD_REQUEST, "허브 좌표가 잘못됐습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}