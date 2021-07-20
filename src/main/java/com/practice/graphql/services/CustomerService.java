package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.entities.AddressEntity;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(Integer id);
    List<Customer> getCustomersSortedAndPaginated(Integer pageNo, Integer pageSize, String sortBy, String sortDirection);
    List<Customer> getCustomersByCity(List<String> cities);
    void createCustomer(String firstName, String lastName, String birthday, String email, AddressEntity addressEntity);

}
