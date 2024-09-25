package com.deliveryMSA.Hubs.domain.hubs.service;

import com.deliveryMSA.Hubs.domain.hubs.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hubs.domain.hubs.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hubs.domain.hubs.model.Hubs;

public interface HubsService {

    Hubs createHub(CreateHubRequestDto requestDto);

    Hubs updateHub(UpdateHubRequestDto requestDto);

    void deleteHub(Integer hubId);
}
