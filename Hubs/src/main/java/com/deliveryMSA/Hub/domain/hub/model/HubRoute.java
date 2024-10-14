package com.deliveryMSA.Hub.domain.hub.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p_hub_route")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class HubRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hubRouteId;

    @Column(name = "hub_route_name")
    private String routeName;  // 경로 이름, 이름은 검색하기 쉽게 hub의 route index

    @Column(name = "start_hub_id", nullable = false)
    private Integer startHubId;  // 출발 허브

    @Column(name = "end_hub_id", nullable = false)
    private Integer endHubId;  // 도착 허브

    @Column(name = "duration(min)", nullable = false)
    private Integer duration;

    @Column(name = "distance(km)" ,nullable = false)
    private Integer distance;

    @Column(nullable = false)
    private Boolean isDeleted = Boolean.FALSE;

    @Builder(access = AccessLevel.PRIVATE)
    private HubRoute(Hub startHub, Hub endHub, Integer duration, Integer distance) {
        this.startHubId = startHub.getId();
        this.endHubId = endHub.getId();
        this.duration = duration;
        this.routeName = startHub.getRouteOrder() + "_to_" + endHub.getRouteOrder();
        this.distance = distance;
    }

    // Route 생성 메서드
    public static HubRoute createRoute(Hub startHub, Hub endHub, Integer duration, Integer distance) {

        return HubRoute.builder()
                .startHubId(startHub.getId())
                .endHubId(endHub.getId())
                .duration(duration)
                .routeName(startHub.getRouteOrder() + "_to_" + endHub.getRouteOrder())
                .distance(distance)
                .build();
    }

    // 경로 정보 업데이트 메서드
    public void updateRoute(Hub startHub, Hub endHub, Integer duration) {
        this.startHubId = startHub.getId();
        this.endHubId = endHub.getId();
        this.duration = duration;
        this.routeName = startHub.getRouteOrder() + "_to_" + endHub.getRouteOrder();
    }

    public void softDeleteRoute() {
        this.isDeleted = Boolean.TRUE;
    }

    // 허브가 지워졌을때 관련 허브 이동경로 정보 소프트 삭제
    public void softDeleteRoutesWhenHubDeleted(List<HubRoute> routeList) {

        routeList.stream().forEach(HubRoute::softDeleteRoute);
    }
}