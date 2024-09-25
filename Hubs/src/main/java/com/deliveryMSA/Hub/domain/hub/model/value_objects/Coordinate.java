package com.deliveryMSA.Hub.domain.hub.model.value_objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Coordinate {
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    protected Coordinate() {}; // JPA only

    public Coordinate(double latitude, double longitude) {

        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Invalid coordinate");
        }  // Validation logic can be added here if needed.

        this.latitude = latitude;
        this.longitude = longitude;
    }
}
