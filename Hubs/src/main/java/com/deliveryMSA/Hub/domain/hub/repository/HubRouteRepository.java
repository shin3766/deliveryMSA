package com.deliveryMSA.Hub.domain.hub.repository;

import com.deliveryMSA.Hub.domain.hub.model.HubRoute;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HubRouteRepository extends JpaRepository<HubRoute, Long> {

    Optional<List<HubRoute>> findAllByRouteNameContaining(String routeName);
}
