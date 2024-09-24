package com.deliveryMSA.Hubs.domain.hubs.dto.request;

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
