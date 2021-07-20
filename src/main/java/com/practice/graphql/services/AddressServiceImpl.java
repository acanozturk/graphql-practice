package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Address;
import com.practice.graphql.api.mappers.AddressMapper;
import com.practice.graphql.entities.AddressEntity;
import com.practice.graphql.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public Address getAddressById(final Integer id) {
        final AddressEntity addressEntity = addressRepository.findAddressEntityById(id);

        return addressMapper.addressEntityToAddressDTO(addressEntity);
    }

    @Override
    public AddressEntity createAddress(final String country, final String city, final String zip) {
        final AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCountry(country);
        addressEntity.setCity(city);
        addressEntity.setZip(zip);

        addressRepository.save(addressEntity);

        return addressEntity;
    }
}
