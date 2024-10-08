package com.deliveryMSA.Hub.service;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.CreateHubResponseDto;
import com.deliveryMSA.Hub.domain.hub.model.Hub;
import com.deliveryMSA.Hub.domain.hub.model.HubRoute;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.HubName;
import com.deliveryMSA.Hub.domain.hub.repository.HubRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@DisplayName("Hub Entity 테스트")
class HubEntityTest {

    @Autowired
    HubRepository hubRepository;

    @BeforeAll
    void setup() throws Exception {

        hubRepository.deleteAll();

        Hub startHub = Hub.from(new CreateHubRequestDto(
                "출발 허브",
                "city",
                "district",
                "street",
                12,
                13
        ));

        Hub endHub = Hub.from(new CreateHubRequestDto(
                "도착 허브",
                "city2",
                "district2",
                "street2",
                14,
                15
        ));

        // 출발, 도착 hub 생성
        hubRepository.save(startHub);
        hubRepository.save(endHub);
    }

    @DisplayName("softDelete 테스트")
    @Test
    void hubSoftDeleteTest() throws Exception {
        //given
        Hub start = hubRepository.findByhubName(new HubName("출발 허브"));
        Hub end = hubRepository.findByhubName(new HubName("도착 허브"));

        HubRoute route = HubRoute.createRoute(start, end, 60);

        //when

        //then
    }
}
