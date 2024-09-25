package com.deliveryMSA.Hub.domain.hub.controller;

import static com.deliveryMSA.Hub.domain.hub.message.SuccessMessage.CREATED_Hub;
import static com.deliveryMSA.Hub.global.message.SuccessResponse.success;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.response.CreateHubResponseDto;
import com.deliveryMSA.Hub.domain.hub.service.HubService;
import com.deliveryMSA.Hub.domain.hub.service.HubServiceImpl;
import com.deliveryMSA.Hub.global.message.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HubController {
    private final HubService HubService;
    HubController(HubServiceImpl Hubervice) {
        this.HubService = Hubervice;
    }

    @PostMapping("/Hub")
    public ResponseEntity<? extends CommonResponse> createHub(
            @RequestBody CreateHubRequestDto requestDto
    ) {

        CreateHubResponseDto responseDto = HubService.createHub(requestDto);

        return ResponseEntity.status(CREATED_Hub.getStatus())
                .body(success(CREATED_Hub.getMessage(), responseDto));
    }
}
