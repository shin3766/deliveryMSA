package com.deliveryMSA.Hub.domain.hub.dto.response;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UpdateHubResponseDto(

        String hubName,
        String city,
        String district,
        String street,
        double latitude,
        double longitude
) {

    public static UpdateHubResponseDto from(Hub Hub) {

        return UpdateHubResponseDto.builder()
                .hubName(Hub.getHubName().getValue())
                .city(Hub.getAddress().getCity())
                .district(Hub.getAddress().getDistrict())
                .street(Hub.getAddress().getStreet())
                .latitude(Hub.getCoordinate().getLatitude())
                .longitude(Hub.getCoordinate().getLongitude())
                .build();
    }
}
