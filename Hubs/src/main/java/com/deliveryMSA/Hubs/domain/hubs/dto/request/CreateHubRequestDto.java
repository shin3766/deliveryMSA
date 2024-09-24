package com.deliveryMSA.Hubs.domain.hubs.dto.request;

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
