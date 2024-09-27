package com.deliveryMSA.Hub.domain.hub.model.value_objects;

import static com.deliveryMSA.Hub.domain.hub.message.ExceptionMessage.HUB_INVALID_ADDRESS;

import com.deliveryMSA.Hub.domain.hub.exception.HubException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coordinate {

    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "longitude", nullable = false)
    private double longitude;

    public Coordinate(double latitude, double longitude) {

        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            throw new HubException(HUB_INVALID_ADDRESS);
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
