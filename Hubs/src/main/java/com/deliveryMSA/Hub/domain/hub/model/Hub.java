package com.deliveryMSA.Hub.domain.hub.model;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.Address;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.Coordinate;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.HubName;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p_hub")
@Getter
@Access(AccessType.FIELD)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Embedded
    private HubName hubName;

    @Embedded
    private Address address;

    @Embedded
    private Coordinate coordinate;

    private boolean isDeleted = Boolean.FALSE;

    @Builder(access = AccessLevel.PRIVATE)
    public Hub(HubName hubName, Address address, Coordinate coordinate) {
        this.hubName = hubName;
        this.address = address;
        this.coordinate = coordinate;
    }

    // hub 생성
    public static Hub from(CreateHubRequestDto requestDto) {

        return Hub.builder()
                .hubName(new HubName(requestDto.hubName()))
                .address(new Address(requestDto.city(), requestDto.district(), requestDto.street()))
                .coordinate(new Coordinate(requestDto.latitude(), requestDto.longitude()))
                .build();
    }

    // hub 업데이트
    public void update(UpdateHubRequestDto requestDto) {
        this.hubName = new HubName(requestDto.hubName());
        this.address = new Address(requestDto.city(), requestDto.district(), requestDto.street());
        this.coordinate = new Coordinate(requestDto.latitude(), requestDto.longitude());
    }

    // hub 삭제
    public void deleteHub() {
        this.isDeleted = Boolean.TRUE;
    }
}
