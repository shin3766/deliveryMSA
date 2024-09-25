package com.deliveryMSA.Hub.domain.hub.dto.request;

import lombok.AccessLevel;
import lombok.Builder;

public record UpdateHubRequestDto(
        String name,
        String city,
        String district,
        String street,
        String houseNumber,
        double latitude,
        double longitude
) {

}
