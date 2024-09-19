package com.deliveryMSA.Herbs.domain.herbs.model;

import com.deliveryMSA.Herbs.domain.herbs.model.value_objects.Address;
import com.deliveryMSA.Herbs.domain.herbs.model.value_objects.Coordinate;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class Herbs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Herbs_id", nullable = false)
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Coordinate coordinate;

}
