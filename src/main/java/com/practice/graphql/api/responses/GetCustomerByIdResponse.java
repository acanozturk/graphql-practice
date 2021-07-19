package com.practice.graphql.api.responses;

import com.practice.graphql.api.dtos.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetCustomerByIdResponse extends AbstractBaseResponse {

    private Customer customer;
}
