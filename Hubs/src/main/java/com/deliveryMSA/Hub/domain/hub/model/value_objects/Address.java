package com.deliveryMSA.Hub.domain.hub.model.value_objects;

import com.deliveryMSA.Hub.domain.hub.exception.HubException;
import com.deliveryMSA.Hub.domain.hub.message.ExceptionMessage;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String street;

    // null, 빈 값, 공백 체크
    public Address(String city, String district, String street) {

        if (city == "세종특별자치시") {
            district = "특수 행정 지역입니다";
        }

        if (city == null || city.trim().isEmpty() ||
                district == null || district.trim().isEmpty() ||
                street == null || street.trim().isEmpty()) {
            throw new HubException(ExceptionMessage.HUB_INVALID_ADDRESS);
        }

        this.city = city;
        this.district = district;
        this.street = street;
    }
}