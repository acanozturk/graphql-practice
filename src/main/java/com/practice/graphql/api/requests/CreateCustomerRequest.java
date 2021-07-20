package com.practice.graphql.api.requests;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String country;
    private String city;
    private String zip;

}
