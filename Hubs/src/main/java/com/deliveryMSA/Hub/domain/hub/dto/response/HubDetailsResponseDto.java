package com.deliveryMSA.Hub.domain.hub.dto.response;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record HubDetailsResponseDto(
        Integer id,
        String name,
        String city,
        String district,
        String street,
        String houseNumber,
        double latitude,
        double longitude
) {

    public static HubDetailsResponseDto from(Hub hub) {

        return HubDetailsResponseDto.builder()
                .id(hub.getId())
                .name(hub.getName())
                .city(hub.getAddress().getCity())
                .district(hub.getAddress().getDistrict())
                .street(hub.getAddress().getStreet())
                .houseNumber(hub.getAddress().getHouseNumber())
                .latitude(hub.getCoordinate().getLatitude())
                .longitude(hub.getCoordinate().getLongitude())
                .build();
    }
}
