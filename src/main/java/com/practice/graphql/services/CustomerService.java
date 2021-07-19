package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(Integer id);
    List<Customer> getCustomersPaginatedAndSorted(Integer pageNo, Integer pageSize, String sortBy, String sortDirection);

}
