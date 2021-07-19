package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Customer;

public interface CustomerService {

    Customer getCustomerById(Integer id);
}
