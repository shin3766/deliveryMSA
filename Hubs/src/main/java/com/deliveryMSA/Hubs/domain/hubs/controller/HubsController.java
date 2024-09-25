package com.deliveryMSA.Hubs.domain.hubs.controller;

import static com.deliveryMSA.Hubs.domain.hubs.message.SuccessMessage.CREATED_HUBS;
import static com.deliveryMSA.Hubs.global.message.SuccessResponse.success;

import com.deliveryMSA.Hubs.domain.hubs.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hubs.domain.hubs.dto.response.CreateHubsResponseDto;
import com.deliveryMSA.Hubs.domain.hubs.service.HubsService;
import com.deliveryMSA.Hubs.domain.hubs.service.HubsServiceImpl;
import com.deliveryMSA.Hubs.global.message.CommonResponse;
import com.deliveryMSA.Hubs.global.message.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HubsController {
    private final HubsService hubsService;
    HubsController(HubsServiceImpl hubService) {
        this.hubsService = hubService;
    }

    @PostMapping("/hubs")
    public ResponseEntity<? extends CommonResponse> createHubs(
            @RequestBody CreateHubRequestDto requestDto
    ) {

        CreateHubsResponseDto responseDto = hubsService.createHubs(requestDto);

        return ResponseEntity.status(CREATED_HUBS.getStatus())
                .body(success(CREATED_HUBS.getMessage(), responseDto));
    }
}
