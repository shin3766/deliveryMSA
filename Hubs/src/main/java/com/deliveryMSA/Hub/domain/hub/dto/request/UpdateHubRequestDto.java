package com.deliveryMSA.Hub.domain.hub.dto.request;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
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
    public static UpdateHubRequestDto from(Hub Hub) {

        return UpdateHubRequestDto.builder()
                .name(Hub.getName())
                .city(Hub.getAddress().getCity())
                .district(Hub.getAddress().getDistrict())
                .street(Hub.getAddress().getStreet())
                .houseNumber(Hub.getAddress().getHouseNumber())
                .latitude(Hub.getCoordinate().getLatitude())
                .longitude(Hub.getCoordinate().getLongitude())
                .build();
    }
}
