package com.deliveryMSA.Hub.domain.hub.dto.request;

public record CreateHubRequestDto(
    String name,
    String city,
    String district,
    String street,
    String houseNumber,
    double latitude,
    double longitude
    ) {
}
