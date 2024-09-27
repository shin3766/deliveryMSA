package com.deliveryMSA.Hub.domain.hub.repository;

import com.deliveryMSA.Hub.domain.hub.model.Hub;
import com.deliveryMSA.Hub.domain.hub.model.value_objects.HubName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HubRepository extends JpaRepository<Hub, Integer> {

}
