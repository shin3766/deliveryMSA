package com.deliveryMSA.Hubs.domain.hubs.model;

import com.deliveryMSA.Hubs.domain.hubs.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hubs.domain.hubs.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hubs.domain.hubs.model.value_objects.Address;
import com.deliveryMSA.Hubs.domain.hubs.model.value_objects.Coordinate;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
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
@Table(name = "hub")
@Getter
@Access(AccessType.FIELD)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hubs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Hubs_id", nullable = false)
    private Integer id;
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Coordinate coordinate;
    private boolean isDeleted = Boolean.FALSE;

    @Builder(access = AccessLevel.PRIVATE)
    public Hubs(String name, Address address, Coordinate coordinate) {
        this.name = name;
        this.address = address;
        this.coordinate = coordinate;
    }

    // hub 생성
    public static Hubs from(CreateHubRequestDto requestDto) {

        return Hubs.builder()
                .name(requestDto.name())
                .address(new Address(requestDto.city(), requestDto.district(), requestDto.street(),
                        requestDto.houseNumber()))
                .coordinate(new Coordinate(requestDto.latitude(), requestDto.longitude()))
                .build();
    }

    // hub 업데이트
    public void update(UpdateHubRequestDto requestDto) {
        this.name = requestDto.name();
        this.address = new Address(requestDto.city(), requestDto.district(), requestDto.street(),
                requestDto.houseNumber());
        this.coordinate = new Coordinate(requestDto.latitude(), requestDto.longitude());
    }

    // hub 삭제
    public void deleteHub() {
        this.isDeleted = Boolean.TRUE;
    }
}
