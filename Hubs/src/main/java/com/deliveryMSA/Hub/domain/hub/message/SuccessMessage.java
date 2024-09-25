package com.deliveryMSA.Hub.domain.hub.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    CREATED_HUB(HttpStatus.CREATED, "허브가 생성되었습니다."),
    UPDATED_HUB(HttpStatus.OK, "허브가 수정되었습니다."),
    GET_HUB(HttpStatus.OK, "허브 조회가 완료되었습니다."),
    DELETE_HUB(HttpStatus.OK, "허브가 삭제되었습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
