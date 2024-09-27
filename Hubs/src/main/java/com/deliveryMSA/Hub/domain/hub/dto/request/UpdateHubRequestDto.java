package com.deliveryMSA.Hub.domain.hub.dto.request;

public record UpdateHubRequestDto(
        String hubName,
        String city,
        String district,
        String street,
        String houseNumber,
        double latitude,
        double longitude
) {

}
