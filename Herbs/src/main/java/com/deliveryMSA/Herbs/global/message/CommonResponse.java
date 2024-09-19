package com.deliveryMSA.Herbs.global.message;

import lombok.NonNull;

public interface CommonResponse {

    boolean success();

    @NonNull
    String message();

}
