package com.practice.graphql.repositories;

import com.practice.graphql.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    CustomerEntity findCustomerEntityById(Integer id);
    List<CustomerEntity> findCustomerEntityByAddressEntity_CityOrderByFirstName(String city);
}

