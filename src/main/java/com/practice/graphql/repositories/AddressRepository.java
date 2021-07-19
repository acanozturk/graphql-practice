package com.practice.graphql.repositories;

import com.practice.graphql.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

    AddressEntity findAddressEntityById(Integer id);
}
