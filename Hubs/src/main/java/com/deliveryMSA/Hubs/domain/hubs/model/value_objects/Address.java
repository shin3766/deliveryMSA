package com.deliveryMSA.Hubs.domain.hubs.model.value_objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String district;
    private String street;
    private String houseNumber;

    // JPA only
    protected Address() {}

    // null, 빈 값, 공백 체크
    public Address(String city, String district, String street, String houseNumber) {

        if (city == null || city.trim().isEmpty() ||
                district == null || district.trim().isEmpty() ||
                street == null || street.trim().isEmpty() ||
                houseNumber == null || houseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Address values cannot be null or empty");
        }
        this.city = city;
        this.district = district;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}