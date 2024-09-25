package com.deliveryMSA.Hub.domain.hub.service;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.CreateHubResponseDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.UpdateHubResponseDto;

public interface HubService {

    CreateHubResponseDto createHub(CreateHubRequestDto requestDto);

    UpdateHubResponseDto updateHub(UpdateHubRequestDto requestDto);

    void deleteHub(Integer hubId);
}
