package com.deliveryMSA.Hub.domain.hub.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    CREATED_Hub(HttpStatus.CREATED, "허브가 생성되었습니다."),
    UPDATED_Hub(HttpStatus.OK, "허브가 수정되었습니다."),
    GET_Hub(HttpStatus.OK, "허브 조회가 완료되었습니다."),
    DELETE_Hub(HttpStatus.OK, "허브가 삭제되었습니다.");

    private final HttpStatus status;
    private final String message;
}
