package com.practice.graphql.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends AbstractBaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String birthday;

    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

}
