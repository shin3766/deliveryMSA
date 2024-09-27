package com.deliveryMSA.Hub.domain.hub.dto.response;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record HubDetailsResponseDto(
        Integer id,
        String hubName,
        String city,
        String district,
        String street,
        double latitude,
        double longitude
) {

    public static HubDetailsResponseDto from(Hub hub) {

        return HubDetailsResponseDto.builder()
                .id(hub.getId())
                .hubName(hub.getHubName().getValue())
                .city(hub.getAddress().getCity())
                .district(hub.getAddress().getDistrict())
                .street(hub.getAddress().getStreet())
                .latitude(hub.getCoordinate().getLatitude())
                .longitude(hub.getCoordinate().getLongitude())
                .build();
    }
}
