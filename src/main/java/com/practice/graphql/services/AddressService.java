package com.practice.graphql.services;

import com.practice.graphql.entities.AddressEntity;

public interface AddressService {

    AddressEntity createAddress(String country, String city, String zip);

}