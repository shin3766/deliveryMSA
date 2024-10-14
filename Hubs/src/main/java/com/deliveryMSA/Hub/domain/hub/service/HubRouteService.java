package com.deliveryMSA.Hub.domain.hub.service;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import com.deliveryMSA.Hub.domain.hub.model.HubRoute;
import com.deliveryMSA.Hub.domain.hub.repository.HubRouteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
기능 ::
허브 루트 생성
허브 루트 수정
허브 루트 삭제
허브 루트 상세 조회
허브 루트 전체 조회

추가 필요::
1. hub soft 삭제시 hubroute도 트랜잭션 전파될 수 있도록해야함
2. deleteHubRoutesWhenHubIsRemoved 메서드 예외처리 필요
 */
@Service
@RequiredArgsConstructor
public class HubRouteService {

    private final HubRouteRepository hubRouteRepository;

//    public CreateHubRouteResponseDto createHubRoute(CreateHubRouteRequestDto requestdto) {
//
//        HubRoute hubRoute = hubRouteRepository.save(HubRoute.createRoute(
//                requestdto.startHub,
//                requestdto.endHub,
//                requestdto.duration,
//                requestdto.distance
//        ));
//
//        return CreateHubRouteResponseDto.from(hubRoute);
//    }

//    public GetHubRouteDetailsResponseDto GetHubRouteDetails(
//            GetHubRouteDetailsRequestDto requestdto) {
//
//        HubRoute hubRoute = hubRouteRepository.findById(requestdto.routeId);
//
//        return GetHubRouteDetailsResponseDto.from(hubRoute);
//    }
//
//    public UpdateHubRouteResponseDto updateHubRoute(UpdateHubRouteRequestDto requestdto) {
//
//        HubRoute hubRoute = hubRouteRepository.findById(requestdto.routeId);
//        hubRoute.updateRoute(requestdto);
//
//        return UpdateHubRouteResponseDto.from(hubRoute);
//    }
//
//    public void deleteHubRoute(DeleteHubRouteRequestDto requestdto) {
//
//        HubRoute hubRoute = hubRouteRepository.findById(requestdto.routeId);
//        hubRoute.softDeleteRoute();
//    }
//
//    public void deleteHubRoutesWhenHubIsRemoved(Hub hub) {
//
//        List<HubRoute> routeList = hubRouteRepository.findAllByRouteNameContaining(
//                        hub.getRouteOrder() + "")
//                .orElseThrow(() -> new IllegalArgumentException(
//                        "Route not found: " + hub.getRouteOrder()));
//
//    }
//
//    public List<GetHubRouteListResponseDto> GetHubRouteList(GetHubRouteListRequestDto requestDto) {
//
//    }
}
