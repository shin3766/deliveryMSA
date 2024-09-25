package com.deliveryMSA.Hub.global.message;

import lombok.NonNull;

public interface CommonResponse {

    boolean success();

    @NonNull
    String message();

}
