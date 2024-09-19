package com.deliveryMSA.Herbs.domain.herbs.model.value_objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String cityOrProvince;
    private String district;
    private String street;
    private String houseNumber;

    protected Address() {}  // JPA only

    public Address(String cityOrProvince, String district, String street, String houseNumber) {

        if (cityOrProvince == null || cityOrProvince.isEmpty() ||
                district == null || district.isEmpty() ||
                street == null || street.isEmpty() ||
                houseNumber == null || houseNumber.isEmpty()) {
            throw new IllegalArgumentException("Address values cannot be null or empty");
        }
        this.cityOrProvince = cityOrProvince;
        this.district = district;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}