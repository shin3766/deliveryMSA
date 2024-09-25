package com.deliveryMSA.Hubs.domain.hubs.service;

import com.deliveryMSA.Hubs.domain.hubs.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hubs.domain.hubs.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hubs.domain.hubs.model.Hubs;
import com.deliveryMSA.Hubs.domain.hubs.repository.HubsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HubsServiceImpl implements HubsService{

    private final HubsRepository hubsRepository;

    @Override
    public Hubs createHub(CreateHubRequestDto requestDto) {
        return null;
    }

    @Override
    public Hubs updateHub(UpdateHubRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteHub(Integer hubId) {

    }
}
