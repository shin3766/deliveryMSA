package com.deliveryMSA.Hub.service;

import static com.deliveryMSA.Hub.domain.hub.message.ExceptionMessage.HUB_INVALID_ADDRESS;
import static com.deliveryMSA.Hub.domain.hub.message.ExceptionMessage.HUB_INVALID_HUB_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.exception.HubException;
import com.deliveryMSA.Hub.domain.hub.repository.HubRepository;
import com.deliveryMSA.Hub.domain.hub.service.HubServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@DisplayName("HubService 테스트")
class HubServiceImplTest {

    @Autowired
    HubServiceImpl hubServiceImpl;

    @Autowired
    protected HubRepository hubRepository;

    @DisplayName("name이 없는 Dto를 사용해 Hub 생성")
    @Test
    void CreateHubFromDtoWithoutName() throws Exception {
        //given
        CreateHubRequestDto requestDto = new CreateHubRequestDto(
                "",
                "서울특별시",
                "송파구",
                "송파대로 55",
                "",
                37.4742027808565,
                127.123621185562
        );
        //when //then
        assertThatThrownBy(() -> hubServiceImpl.createHub(requestDto))
                .isInstanceOf(HubException.class)
                .hasMessage(HUB_INVALID_HUB_NAME.getMessage());
    }

    @DisplayName("city가 없는 Dto를 사용해 Hub 생성")
    @Test
    void CreateHubFromDtoWithoutCity() throws Exception {
        //given
        CreateHubRequestDto requestDto = new CreateHubRequestDto(
                "서울특별시 센터",
                "",
                "송파구",
                "송파대로 55",
                "",
                37.4742027808565,
                127.123621185562
        );
        //when
        //then
        assertThatThrownBy(() -> hubServiceImpl.createHub(requestDto))
                .isInstanceOf(HubException.class)
                .hasMessage(HUB_INVALID_ADDRESS.getMessage());
    }

    @DisplayName("city가 없는 세종특별자치시 Dto를 사용해 Hub 생성")
    @Test
    void CreateHubFromDtoWithoutCityButSejongSi() throws Exception {
        //given
        CreateHubRequestDto requestDto = new CreateHubRequestDto(
                "세종시 센터",
                "세종특별자치시",
                "",
                "송파대로 55",
                "",
                37.4742027808565,
                127.123621185562
        );
        //when
        var response = hubServiceImpl.createHub(requestDto);

        //then
        assertThat(hubRepository.findById(response.id()).get().getAddress().getCity())
                .isEqualTo("세종특별자치시");
        assertThat(hubRepository.findById(response.id()).get().getAddress().getDistrict())
                .isEqualTo("특수 행정 지역입니다");
    }

    @DisplayName("district가 없는 Dto를 사용해 Hub 생성")
    @Test
    void CreateHubFromDtoWithoutDistrict() throws Exception {
        //given
        CreateHubRequestDto requestDto = new CreateHubRequestDto(
                "서울특별시 센터",
                "서울특별시",
                "",
                "송파대로 55",
                "",
                37.4742027808565,
                127.123621185562
        );
        //when//then
        assertThatThrownBy(() -> hubServiceImpl.createHub(requestDto))
                .isInstanceOf(HubException.class)
                .hasMessage(HUB_INVALID_ADDRESS.getMessage());
    }

    @DisplayName("street가 없는 Dto를 사용해 Hub 생성")
    @Test
    void CreateHubFromDtoWithoutStreet() throws Exception {
        //given
        CreateHubRequestDto requestDto = new CreateHubRequestDto(
                "서울특별시 센터",
                "서울특별시",
                "송파구",
                "",
                "",
                37.4742027808565,
                127.123621185562
        );
        //when//then
        assertThatThrownBy(() -> hubServiceImpl.createHub(requestDto))
                .isInstanceOf(HubException.class)
                .hasMessage(HUB_INVALID_ADDRESS.getMessage());
    }
}
