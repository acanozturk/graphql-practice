package com.practice.graphql.api.mappers;

import com.practice.graphql.api.dtos.Address;
import com.practice.graphql.entities.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address addressEntityToAddressDTO(AddressEntity addressEntity);
    AddressEntity addressDTOToAddressEntity(Address address);

}
