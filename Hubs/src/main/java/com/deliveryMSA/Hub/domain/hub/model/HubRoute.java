package com.deliveryMSA.Hub.domain.hub.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne
    @JoinColumn(name = "start_hub_id", nullable = false)
    private Hub startHub;  // 출발 허브

    @ManyToOne
    @JoinColumn(name = "end_hub_id", nullable = false)
    private Hub endHub;  // 도착 허브

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Boolean isDeleted = Boolean.FALSE;

    // Route 생성 메서드
    public static HubRoute createRoute(Hub startHub, Hub endHub, Integer duration) {

        return HubRoute.builder()
                .startHub(startHub)
                .endHub(endHub)
                .duration(duration)
                .build();
    }

    // 경로 정보 업데이트 메서드
    public void updateRoute(Hub startHub, Hub endHub, Integer duration) {
        this.startHub = startHub;
        this.endHub = endHub;
        this.duration = duration;
    }

    public void softDeleteRoute() {
        this.isDeleted = Boolean.TRUE;
    }
}