package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Address;
import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.api.mappers.CustomerMapper;
import com.practice.graphql.entities.CustomerEntity;
import com.practice.graphql.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressService addressService;

    @Override
    public Customer getCustomerById(final Integer id) {
        final CustomerEntity customerEntity = customerRepository.findCustomerEntityById(id);
        final Address address = addressService.getAddressById(customerEntity.getAddressEntity().getId());

        final Customer customer = customerMapper.customerEntityToCustomerDTO(customerEntity);
        customer.setAddress(address);

        return customer;
    }
}