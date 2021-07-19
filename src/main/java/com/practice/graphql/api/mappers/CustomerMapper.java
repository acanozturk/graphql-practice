package com.practice.graphql.api.mappers;

import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerEntityToCustomerDTO(CustomerEntity customerEntity);
    CustomerEntity customerDTOToCustomerEntity(Customer customer);

}
