package com.practice.graphql.repositories;

import com.practice.graphql.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    CustomerEntity findCustomerEntityById(Integer id);
}
