package com.practice.graphql.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressEntity extends AbstractBaseEntity {

    private String country;
    private String city;
    private String zip;

}
