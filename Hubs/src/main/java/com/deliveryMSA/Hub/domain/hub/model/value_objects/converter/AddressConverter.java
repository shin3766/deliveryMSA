package com.deliveryMSA.Hub.domain.hub.model.value_objects.converter;

import com.deliveryMSA.Hub.domain.hub.model.value_objects.Address;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<Address, String> {

    @Override
    public String convertToDatabaseColumn(Address address) {

        if (address == null) {
            return null;
        }

        return new StringBuilder()
                .append(address.getCity())
                .append(".")
                .append(address.getDistrict())
                .append(".")
                .append(address.getStreet())
                .append(".")
                .append(address.getHouseNumber())
                .toString();
    }

    @Override
    public Address convertToEntityAttribute(String value) {

        if (value == null) {
            return null;
        }
        final String[] parts = value.split("\\.");
        String city = parts[0];
        String district = parts[1];
        String street = parts[2];
        String houseNumber = parts[3];

        return new Address(city, district, street, houseNumber);
    }
}
