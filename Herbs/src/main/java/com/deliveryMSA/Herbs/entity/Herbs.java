package com.deliveryMSA.Herbs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Herbs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Herbs_id", nullable = false)
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double altitude;
}
