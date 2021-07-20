package com.practice.graphql.api.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends AbstractBaseDTO {

    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private Address address;

}
