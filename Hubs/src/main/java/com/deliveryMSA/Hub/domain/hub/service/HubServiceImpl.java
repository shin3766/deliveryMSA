package com.deliveryMSA.Hub.domain.hub.service;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.CreateHubResponseDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.UpdateHubResponseDto;
import com.deliveryMSA.Hub.domain.hub.model.Hub;
import com.deliveryMSA.Hub.domain.hub.repository.HubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HubServiceImpl implements HubService {

    private final HubRepository hubRepository;

    @Override
    public CreateHubResponseDto createHub(CreateHubRequestDto requestDto) {

        Hub hub = Hub.from(requestDto);
        hubRepository.save(hub);
        CreateHubResponseDto responseDto = CreateHubResponseDto.from(hub);

        return responseDto;
    }

    @Override
    public UpdateHubResponseDto updateHub(UpdateHubRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteHub(Integer hubId) {

    }
}
