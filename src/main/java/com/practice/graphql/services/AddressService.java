package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Address;

public interface AddressService {

    Address getAddressById(Integer id);
}
