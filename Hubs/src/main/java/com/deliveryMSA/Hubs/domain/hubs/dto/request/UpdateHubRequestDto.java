package com.deliveryMSA.Hubs.domain.hubs.dto.request;

import com.deliveryMSA.Hubs.domain.hubs.model.Hubs;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UpdateHubRequestDto(
        String name,
        String city,
        String district,
        String street,
        String houseNumber,
        double latitude,
        double longitude
) {
    public static UpdateHubRequestDto from(Hubs hubs) {

        return UpdateHubRequestDto.builder()
                .name(hubs.getName())
                .city(hubs.getAddress().getCity())
                .district(hubs.getAddress().getDistrict())
                .street(hubs.getAddress().getStreet())
                .houseNumber(hubs.getAddress().getHouseNumber())
                .latitude(hubs.getCoordinate().getLatitude())
                .longitude(hubs.getCoordinate().getLongitude())
                .build();
    }
}
