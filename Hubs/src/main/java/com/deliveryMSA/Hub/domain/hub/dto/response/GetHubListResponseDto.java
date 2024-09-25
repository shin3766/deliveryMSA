package com.deliveryMSA.Hub.domain.hub.dto.response;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record GetHubListResponseDto(
) {

}