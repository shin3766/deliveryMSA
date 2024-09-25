package com.deliveryMSA.Hub.service;

import static com.deliveryMSA.Hub.domain.hub.message.ExceptionMessage.HUB_INVALID_ADDRESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.CreateHubResponseDto;
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
                .hasMessage(HUB_INVALID_ADDRESS.getMessage());
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
        //when//then
        assertThatThrownBy(() -> hubServiceImpl.createHub(requestDto))
                .isInstanceOf(HubException.class)
                .hasMessage(HUB_INVALID_ADDRESS.getMessage());
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

    @DisplayName("houseNumber가 없는 Dto를 사용해 Hub 생성")
    @Test
    void CreateHubFromDtoWithoutHouseNumber() throws Exception {
        //given
        CreateHubRequestDto requestDto = new CreateHubRequestDto(
                "서울특별시 센터",
                "서울특별시",
                "송파구",
                "송파대로 55",
                "",
                37.4742027808565,
                127.123621185562
        );
        //when
        CreateHubResponseDto responseDto = hubServiceImpl.createHub(requestDto);

        // then
        assertThat(responseDto).isNotNull();
        assertThat(hubRepository.existsById(responseDto.id())).isTrue();
    }
}
