package com.deliveryMSA.Hub.domain.hub.dto.response;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import lombok.Builder;

/**
 * DTO for {@link Hub}
 */

@Builder
public record CreateHubResponseDto(

        Integer id,
        String name,
        String city,
        String district,
        String street,
        String houseNumber,
        double latitude,
        double longitude
) {
    public static CreateHubResponseDto from(Hub Hub) {

        return CreateHubResponseDto.builder()
               .id(Hub.getId())
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