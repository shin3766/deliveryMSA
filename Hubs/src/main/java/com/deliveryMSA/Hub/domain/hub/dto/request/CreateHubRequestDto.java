package com.deliveryMSA.Hub.domain.hub.dto.request;

public record CreateHubRequestDto(
    String hubName,
    String city,
    String district,
    String street,
    double latitude,
    double longitude
    ) {
}
