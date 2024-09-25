package com.deliveryMSA.Hub.domain.hub.model.value_objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String street;

    @Column
    private String houseNumber;

    // null, 빈 값, 공백 체크
    public Address(String city, String district, String street, String houseNumber) {

        if (city == null || city.trim().isEmpty() ||
                district == null || district.trim().isEmpty() ||
                street == null || street.trim().isEmpty() ||
                houseNumber == null || houseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("주소가 잘못됐습니다.");
        }
        this.city = city;
        this.district = district;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}