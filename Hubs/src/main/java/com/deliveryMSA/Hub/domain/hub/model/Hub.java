package com.deliveryMSA.Hub.domain.hub.model;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.Address;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.Coordinate;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.HubName;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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

    @OneToMany(mappedBy = "startHub", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HubRoute> startHubRoutes = new ArrayList<>();

    @OneToMany(mappedBy = "endHub", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HubRoute> endHubRoutes = new ArrayList<>();

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
    public void softDeleteHub() {
        this.isDeleted = Boolean.TRUE;

        softDeleteRoutes();
    }

    private void softDeleteRoutes() {
        for (HubRoute startHubRoute : startHubRoutes) {
            startHubRoute.softDeleteRoute();
        }
        for (HubRoute endHubRoute : endHubRoutes) {
            endHubRoute.softDeleteRoute();
        }
    }
}
