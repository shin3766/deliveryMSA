package com.deliveryMSA.Hub.domain.hub.dto.response;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UpdateHubResponseDto(

        String name,
        String city,
        String district,
        String street,
        String houseNumber,
        double latitude,
        double longitude
) {

    public static UpdateHubResponseDto from(Hub Hub) {

        return UpdateHubResponseDto.builder()
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
