package com.deliveryMSA.Hub.domain.hub.model.value_objects;

import static com.deliveryMSA.Hub.domain.hub.message.ExceptionMessage.HUB_INVALID_HUB_NAME;

import com.deliveryMSA.Hub.domain.hub.exception.HubException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HubName {

    @Column(name = "hub_name", nullable = false)
    private String value;

    public HubName(String value) {

        if (value == null || value.trim().isEmpty()) {
            throw new HubException(HUB_INVALID_HUB_NAME);
        }
        this.value = value;
    }
}
