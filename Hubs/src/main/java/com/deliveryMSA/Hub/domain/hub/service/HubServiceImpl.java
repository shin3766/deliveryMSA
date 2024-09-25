package com.deliveryMSA.Hub.domain.hub.service;

import static com.deliveryMSA.Hub.domain.hub.message.ExceptionMessage.HUB_NOT_FOUND;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.CreateHubResponseDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.GetHubListResponseDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.HubDetailsResponseDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.UpdateHubResponseDto;
import com.deliveryMSA.Hub.domain.hub.exception.HubException;
import com.deliveryMSA.Hub.domain.hub.model.Hub;
import com.deliveryMSA.Hub.domain.hub.repository.HubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HubServiceImpl implements HubService {

    private final HubRepository hubRepository;

    @Override
    @Transactional
    public CreateHubResponseDto createHub(CreateHubRequestDto requestDto) {

        Hub hub = Hub.from(requestDto);
        hubRepository.save(hub);

        return CreateHubResponseDto.from(hub);
    }

    @Override
    @Transactional
    public UpdateHubResponseDto updateHub(Integer hubId, UpdateHubRequestDto requestDto) {

        Hub hub = findById(hubId);
        hub.update(requestDto);

        return UpdateHubResponseDto.from(hub);
    }

    @Override
    @Transactional
    public void deleteHub(Integer hubId) {

        Hub hub = findById(hubId);
        hub.deleteHub();
    }

    @Override
    @Transactional(readOnly = true)
    public HubDetailsResponseDto getHubDetails(Integer hubId) {

        return HubDetailsResponseDto.from(findById(hubId));
    }

    @Override
    public GetHubListResponseDto getHubList() {
        return null;
    }

    private Hub findById(Integer hubId) {

        return hubRepository.findById(hubId).orElseThrow(() -> new HubException(HUB_NOT_FOUND));
    }
}
