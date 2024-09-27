package com.deliveryMSA.Hub.domain.hub.model;


import jakarta.persistence.Column;
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
@Table(name = "p_route")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class HubRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer departHubId;

    @Column(nullable = false)
    private Integer arriveHubId;

    @Column(nullable = false)
    private Long duration;

    @Column
    private String routeDisplayName;

    private Boolean isDeleted = Boolean.FALSE;

    // Route 생성 메서드
    public static HubRoute createRoute(Integer departHubId, Integer arriveHubId, Long duration,
            String routeDisplayName) {
        return HubRoute.builder()
                .departHubId(departHubId)
                .arriveHubId(arriveHubId)
                .duration(duration)
                .routeDisplayName(routeDisplayName)
                .build();
    }

    // 경로 정보 업데이트 메서드
    public void updateRoute(Integer departHubId, Integer arriveHubId, Long duration,
            String routeDisplayName) {
        this.departHubId = departHubId;
        this.arriveHubId = arriveHubId;
        this.duration = duration;
        this.routeDisplayName = routeDisplayName;
    }

    public void deleteRoute(Long hubRouteId) {
        this.isDeleted = Boolean.TRUE;
    }
}