package com.deliveryMSA.Hubs.domain.hubs.dto.response;

import com.deliveryMSA.Hubs.domain.hubs.model.Hubs;

/**
 * DTO for {@link Hubs}
 */

public record CreateHubsResponseDto(

        Integer id,
        String name,
        String city,
        String district,
        String street,
        String houseNumber,
        double latitude,
        double longitude
) {
}