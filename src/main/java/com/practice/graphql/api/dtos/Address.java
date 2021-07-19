package com.practice.graphql.api.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends AbstractBaseDTO {

    private String country;
    private String city;
    private String zip;

}
