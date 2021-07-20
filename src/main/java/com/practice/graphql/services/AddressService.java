package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Address;
import com.practice.graphql.entities.AddressEntity;

public interface AddressService {

    Address getAddressById(Integer id);
    AddressEntity createAddress(String country, String city, String zip);
}
