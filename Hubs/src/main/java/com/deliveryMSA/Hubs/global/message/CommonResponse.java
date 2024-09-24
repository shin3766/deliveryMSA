package com.deliveryMSA.Hubs.global.message;

import lombok.NonNull;

public interface CommonResponse {

    boolean success();

    @NonNull
    String message();

}
