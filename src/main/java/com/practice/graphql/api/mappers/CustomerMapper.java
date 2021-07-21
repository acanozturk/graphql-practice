package com.practice.graphql.api.mappers;

import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class})
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "customerEntity.addressEntity", target = "address")
    Customer customerEntityToCustomerDTO(CustomerEntity customerEntity);
    CustomerEntity customerDTOToCustomerEntity(Customer customer);


}
