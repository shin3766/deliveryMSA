package com.deliveryMSA.Hub.domain.hub.controller;

import static com.deliveryMSA.Hub.domain.hub.message.SuccessMessage.CREATED_HUB;
import static com.deliveryMSA.Hub.domain.hub.message.SuccessMessage.DELETE_HUB;
import static com.deliveryMSA.Hub.domain.hub.message.SuccessMessage.GET_HUB;
import static com.deliveryMSA.Hub.domain.hub.message.SuccessMessage.UPDATED_HUB;
import static com.deliveryMSA.Hub.global.message.SuccessResponse.success;

import com.deliveryMSA.Hub.domain.hub.dto.request.CreateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.dto.request.UpdateHubRequestDto;
import com.deliveryMSA.Hub.domain.hub.service.HubService;
import com.deliveryMSA.Hub.domain.hub.service.HubServiceImpl;
import com.deliveryMSA.Hub.global.message.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HubController {

    private final HubService HubService;

    HubController(HubServiceImpl hubServiceImpl) {
        this.HubService = hubServiceImpl;
    }

    @PostMapping("/hubs")
    public ResponseEntity<? extends CommonResponse> createHub(
            @RequestBody CreateHubRequestDto requestDto
    ) {

        return ResponseEntity.status(CREATED_HUB.getHttpStatus())
                .body(success(CREATED_HUB.getMessage(), HubService.createHub(requestDto)));
    }

    // hub 전체 조회
    @GetMapping("/hubs")
    public ResponseEntity<? extends CommonResponse> getAllHubs() {
        // TODO: Implement logic to get all hubs
        return ResponseEntity.ok().build();
    }

    // hub 단일 조회
    @GetMapping("/hubs/{hubId}")
    public ResponseEntity<? extends CommonResponse> getHub(
            @PathVariable Integer hubId) {

        return ResponseEntity.status(GET_HUB.getHttpStatus())
                .body(success(GET_HUB.getMessage(), HubService.getHubDetails(hubId)));
    }

    // hub 업데이트
    @PatchMapping("/hubs/{hubId}")
    public ResponseEntity<? extends CommonResponse> updateHub(
            @PathVariable Integer hubId,
            @RequestBody UpdateHubRequestDto requestDto
    ) {

        return ResponseEntity.status(UPDATED_HUB.getHttpStatus())
                .body(success(UPDATED_HUB.getMessage(), HubService.updateHub(hubId, requestDto)));
    }

    // hub 삭제
    @DeleteMapping("/hubs/{hubId}")
    public ResponseEntity<? extends CommonResponse> deleteHub(
            @PathVariable Integer hubId
    ) {

        HubService.deleteHub(hubId);

        return ResponseEntity.status(DELETE_HUB.getHttpStatus())
                .body(success(DELETE_HUB.getMessage()));
    }
}
